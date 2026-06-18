package com.example.dulich

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class OrderHotelActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.parseColor("#4DA8FF")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderhotel)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val recycler = findViewById<RecyclerView>(R.id.recyclerOrders)
        recycler.layoutManager = LinearLayoutManager(this)

        val orderList = mutableListOf<Order>()
        val adapter = OrderAdapter(orderList) {}
        recycler.adapter = adapter

        val user = auth.currentUser

        if (user != null) {

            db.collection("orders")
                .whereEqualTo("userId", user.uid)
                .addSnapshotListener { value, error ->

                    if (error != null || value == null) return@addSnapshotListener

                    orderList.clear()

                    for (doc in value) {

                        orderList.add(
                            Order(
                                hotelName = doc.getString("hotelName") ?: "",

                                // 🔥 FIX LỖI Ở ĐÂY
                                price = doc.get("price")?.toString() ?: "0",

                                rating = doc.get("rating")?.toString() ?: ""
                            )
                        )
                    }

                    adapter.notifyDataSetChanged()
                }
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }

                R.id.nav_suggest -> {
                    startActivity(Intent(this, SuggestActivity::class.java))
                    true
                }

                R.id.nav_trip -> {
                    startActivity(Intent(this, TripActivity::class.java))
                    true
                }

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }

                else -> false
            }
        }
    }
}