package com.example.dulich


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val user = auth.currentUser

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val btnLogout = findViewById<TextView>(R.id.btnLogout)
        val btnEditAvatar = findViewById<ImageView>(R.id.btnEditAvatar)

        val recycler = findViewById<RecyclerView>(R.id.recyclerBookedTours)
        recycler.layoutManager = LinearLayoutManager(this)

        // ===== USER INFO =====
        if (user != null) {
            txtEmail.text = user.email
            txtName.text = user.displayName ?: "Người dùng"
        }

        // ===== ADAPTER + LIST =====
        val orderList = mutableListOf<Order>()

        val adapter = OrderAdapter(orderList) { order ->

            val intent = Intent(this, OrderDetailActivity::class.java)
            intent.putExtra("name", order.hotelName)
            intent.putExtra("price", order.price)
            intent.putExtra("rating", order.rating)
            startActivity(intent)
        }

        recycler.adapter = adapter

        // ===== FIREBASE LOAD ORDERS (FIXED) =====
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
                                price = doc.getString("price") ?: "",
                                rating = doc.getString("rating") ?: ""
                            )
                        )
                    }

                    adapter.notifyDataSetChanged()
                }
        }

        // ===== LOGOUT =====
        btnLogout.setOnClickListener {
            auth.signOut()

            Toast.makeText(this, "Đã đăng xuất", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

            finish()
        }

        // ===== AVATAR =====
        btnEditAvatar.setOnClickListener {
            Toast.makeText(this, "Đang phát triển", Toast.LENGTH_SHORT).show()
        }
    }
}