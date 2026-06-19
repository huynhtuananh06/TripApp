package com.example.dulich

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class PendingOrdersActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var adapter: PendingOrderAdapter
    private val list = mutableListOf<AdminOrder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_orders)

        db = FirebaseFirestore.getInstance()

        val recycler = findViewById<RecyclerView>(R.id.recyclerPending)
        recycler.layoutManager = LinearLayoutManager(this)

        adapter = PendingOrderAdapter(
            list,
            onConfirm = { order ->
                updateStatus(order.id, "confirmed")
            },
            onReject = { order ->
                updateStatus(order.id, "rejected")
            }
        )

        recycler.adapter = adapter

        loadOrders()

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }

    private fun loadOrders() {
        db.collection("orders")
            .addSnapshotListener { value, error ->

                if (error != null || value == null) return@addSnapshotListener

                list.clear()

                for (doc in value) {
                    list.add(
                        AdminOrder(
                            id = doc.id,
                            userEmail = doc.getString("userEmail") ?: "",
                            hotelName = doc.getString("hotelName") ?: "",
                            price = doc.getDouble("price") ?: 0.0,
                            checkIn = doc.getString("checkIn") ?: "",
                            status = doc.getString("status") ?: "pending"
                        )
                    )
                }

                adapter.notifyDataSetChanged()
            }
    }

    private fun updateStatus(id: String, status: String) {
        db.collection("orders")
            .document(id)
            .update("status", status)
    }
}