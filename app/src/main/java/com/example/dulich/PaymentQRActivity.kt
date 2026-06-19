package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PaymentQRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_qr)

        val txtStatus = findViewById<TextView>(R.id.txtStatus)
        val imgQR = findViewById<ImageView>(R.id.imgQR)

        val txtHotelName = findViewById<TextView>(R.id.txtHotelName)

        val hotelName = intent.getStringExtra("hotelName")
        // UI
        txtHotelName.text = hotelName ?: "Không có tên khách sạn"



        imgQR.setImageResource(R.drawable.qr_momo_demo)
        txtStatus.text = "Đang chờ thanh toán..."

        Handler(Looper.getMainLooper()).postDelayed({

            txtStatus.text = "Thanh toán thành công ✓"

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this@PaymentQRActivity, SuccessActivity::class.java)
                startActivity(intent)
                finish()
            }, 1500)

        }, 5000)
    }
}