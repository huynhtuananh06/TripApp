package com.example.dulich


import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
            Toast.makeText(this, "Chọn MoMo QR", Toast.LENGTH_SHORT).show()
        }

        btnMomoCard.setOnClickListener {
            Toast.makeText(this, "Chọn Card MoMo", Toast.LENGTH_SHORT).show()
        }
    }
}