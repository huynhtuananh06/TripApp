package com.example.dulich


import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class PaymentMethodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_method)

        val btnCash = findViewById<LinearLayout>(R.id.btnCash)
        val btnMomoQR = findViewById<LinearLayout>(R.id.btnMomoQR)
        val btnMomoCard = findViewById<LinearLayout>(R.id.btnMomoCard)


        val hotelName = intent.getStringExtra("hotelName")
        val price = intent.getDoubleExtra("price", 0.0)
        val checkIn = intent.getStringExtra("checkIn")

        btnCash.setOnClickListener {
            Toast.makeText(this, "Chọn tiền mặt", Toast.LENGTH_SHORT).show()
        }

        btnMomoQR.setOnClickListener {

            val orderId = intent.getStringExtra("orderId")


            val intent = Intent(this, PaymentQRActivity::class.java)
            intent.putExtra("orderId", orderId)
            intent.putExtra("hotelName", hotelName)
            intent.putExtra("price", price)

            startActivity(intent)
        }
        btnMomoCard.setOnClickListener {
            Toast.makeText(this, "Chọn Card MoMo", Toast.LENGTH_SHORT).show()
        }
    }
}