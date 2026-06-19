package com.example.dulich

import android.os.Bundle
import java.text.SimpleDateFormat
import java.util.Locale
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
                updateStatus(order.id, "Đã xác nhận")
            },
            onReject = { order ->
                updateStatus(order.id, "Đã từ chối")
            },
            onDelete = {
                deleteOrder(it.id)
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

                    val checkIn = doc.getString("checkIn") ?: ""
                    val bookingStatus = doc.getString("bookingStatus") ?: "Chờ xác nhận"

                    // Kiểm tra hết hạn
                    checkExpiredOrder(
                        doc.id,
                        checkIn,
                        bookingStatus
                    )

                    list.add(
                        AdminOrder(
                            id = doc.id,
                            userEmail = doc.getString("userEmail") ?: "",
                            hotelName = doc.getString("hotelName") ?: "",
                            price = doc.getDouble("price") ?: 0.0,
                            checkIn = checkIn,
                            status = doc.getString("status") ?: "pending",
                            bookingStatus = bookingStatus
                        )
                    )
                }

                adapter.notifyDataSetChanged()
            }
    }
    private fun deleteOrder(id:String){

        db.collection("orders")
            .document(id)
            .delete()
    }

    private fun updateStatus(id: String, bookingStatus: String) {
        db.collection("orders")
            .document(id)
            .update("bookingStatus", bookingStatus)
    }
    private fun checkExpiredOrder(
        orderId: String,
        checkIn: String,
        bookingStatus: String
    ) {

        if (bookingStatus != "Đã xác nhận") return

        try {

            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

            val checkInDate = sdf.parse(checkIn) ?: return

            val expireTime = checkInDate.time + 24 * 60 * 60 * 1000

            if (System.currentTimeMillis() >= expireTime) {

                db.collection("orders")
                    .document(orderId)
                    .update(
                        mapOf(
                            "bookingStatus" to "Đã hết hạn"
                        )
                    )
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}