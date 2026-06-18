package com.example.dulich

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TripActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.parseColor("#4DA8FF")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val recycler = findViewById<RecyclerView>(R.id.recyclerTour)

        // DATA
        val tripMap = mapOf(
            "Bà Nà Hills" to listOf(
                TripItem.TourItem("Mercure Danang French Village Bana Hills", R.drawable.bana1, 1200000, "4.8"),
                TripItem.TourItem("Debay Hotel", R.drawable.bana2, 700000, "4.5"),
                TripItem.TourItem("Morin Hotel Ba Na Hills", R.drawable.bana3, 1700000, "4.5")
            ),

            "Cầu Rồng Đà Nẵng" to listOf(
                TripItem.TourItem("Vanda Hotel", R.drawable.rong1, 1100000, "4.7"),
                TripItem.TourItem("HAIAN Riverfront Hotel", R.drawable.rong2, 1300000, "4.6"),
                TripItem.TourItem("Mitisa Hotel Da Nang", R.drawable.rong3, 900000, "4.5")
            ),

            "Bán đảo Sơn Trà" to listOf(
                TripItem.TourItem("InterContinental Danang Sun Peninsula Resort", R.drawable.sontra1, 8500000, "4.9"),
                TripItem.TourItem("A La Carte Da Nang Beach", R.drawable.sontra2, 1500000, "4.6"),
                TripItem.TourItem("Son Tra Resort & Spa", R.drawable.sontra3, 1200000, "4.4")
            ),

            "Hồ Hoàn Kiếm (Hồ Gươm) - Hà Nội" to listOf(
                TripItem.TourItem("Apricot Hotel", R.drawable.hoguom1, 3200000, "4.8"),
                TripItem.TourItem("Hanoi Pearl Hotel", R.drawable.hoguom2, 1800000, "4.5"),
                TripItem.TourItem("The Oriental Jade Hotel", R.drawable.hoguom3, 3500000, "4.9")
            ),

            "Phố cổ Hà Nội" to listOf(
                TripItem.TourItem("La Siesta Classic Ma May", R.drawable.phoco1, 2600000, "4.8"),
                TripItem.TourItem("Hanoi Old Quarter Hotel", R.drawable.phoco2, 1200000, "4.4"),
                TripItem.TourItem("May De Ville Hotel", R.drawable.phoco3, 2000000, "4.6")
            ),

            "Văn Miếu - Quốc Tử Giám" to listOf(
                TripItem.TourItem("The Ann Hanoi Hotel", R.drawable.vanmieu1, 2800000, "4.7"),
                TripItem.TourItem("Hanoi Emotion Hotel", R.drawable.vanmieu2, 1000000, "4.3"),
                TripItem.TourItem("Pullman Hanoi", R.drawable.vanmieu3, 2900000, "4.6")
            ),

            "Bãi Sao Phú Quốc" to listOf(
                TripItem.TourItem("Premier Village Phu Quoc Resort", R.drawable.baisa1, 6500000, "4.8"),
                TripItem.TourItem("JW Marriott Phu Quoc Emerald Bay", R.drawable.baisa2, 8000000, "4.9"),
                TripItem.TourItem("Ancarine Beach Resort", R.drawable.baisa3, 2500000, "4.5")
            ),

            "Grand World Phú Quốc" to listOf(
                TripItem.TourItem("Vinholidays Fiesta Phú Quốc", R.drawable.grandworld1, 1200000, "4.6"),
                TripItem.TourItem("Solea Hotel Grand World", R.drawable.grandworld2, 900000, "4.5"),
                TripItem.TourItem("Vinpearl Wonderworld Phú Quốc", R.drawable.grandworld3, 3500000, "4.8")
            ),

            "VinWonders Phú Quốc" to listOf(
                TripItem.TourItem("Vinpearl Resort & Spa Phú Quốc", R.drawable.vinwonders1, 3200000, "4.7"),
                TripItem.TourItem("Radisson Blu Resort Phú Quốc", R.drawable.vinwonders2, 2800000, "4.6"),
                TripItem.TourItem("Wyndham Grand Phú Quốc", R.drawable.vinwonders3, 2500000, "4.5")
            )
        )

        val tripList = tripMap.flatMap { (header, items) ->
            listOf(TripItem.Header(header)) + items
        }

        recycler.layoutManager = LinearLayoutManager(this)

        recycler.adapter = TripAdapter(
            tripList,
            onBook = { item ->

                val user = auth.currentUser

                if (user == null) {
                    Toast.makeText(this, "Chưa đăng nhập", Toast.LENGTH_SHORT).show()
                    return@TripAdapter
                }

                val order = hashMapOf(
                    "userId" to user.uid,
                    "hotelName" to item.name,
                    "price" to item.price,
                    "rating" to item.rating,
                    "status" to "pending",
                    "quantity" to 1
                )

                db.collection("orders")
                    .add(order)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Đặt thành công", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Lỗi: ${it.message}", Toast.LENGTH_LONG).show()
                        Log.e("FIREBASE", it.message.toString())
                    }
            },
            onDetail = { }
        )
        val bottomNav =
            findViewById<BottomNavigationView>(
                R.id.bottomNav
            )
        bottomNav.selectedItemId =
            R.id.nav_trip

        bottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> {

                    startActivity(
                        Intent(
                            this,
                            HomeActivity::class.java
                        )
                    )

                    finish() // tùy chọn

                    true
                }

                R.id.nav_suggest -> {

                    startActivity(
                        Intent(
                            this,
                            SuggestActivity::class.java
                        )
                    )

                    finish()

                    true
                }

                R.id.nav_trip -> {

                    startActivity(
                        Intent(
                            this,
                            TripActivity::class.java
                        )
                    )

                    finish()

                    true
                }

                R.id.nav_profile -> {

                    startActivity(
                        Intent(
                            this,
                            ProfileActivity::class.java
                        )
                    )

                    finish()

                    true
                }

                else -> false
            }
        }
    }
}