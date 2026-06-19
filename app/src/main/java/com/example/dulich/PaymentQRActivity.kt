package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class PaymentQRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_qr)

        val txtStatus = findViewById<TextView>(R.id.txtStatus)
        val imgQR = findViewById<ImageView>(R.id.imgQR)

        val txtHotelName = findViewById<TextView>(R.id.txtHotelName)
        val orderId = intent.getStringExtra("orderId")

        val hotelName = intent.getStringExtra("hotelName")
        // UI
        txtHotelName.text = hotelName ?: "Không có tên khách sạn"



        imgQR.setImageResource(R.drawable.qr_momo_demo)
        txtStatus.text = "Đang chờ thanh toán..."

        Handler(Looper.getMainLooper()).postDelayed({

            txtStatus.text = "Thanh toán thành công ✓"

            val orderId = intent.getStringExtra("orderId")

            if (orderId != null) {
                FirebaseFirestore.getInstance()
                    .collection("orders")
                    .document(orderId!!)
                    .update(
                        mapOf(
                            "status" to "paid",
                            "bookingStatus" to "Chờ xác nhận"
                        )
                    )

            }

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, SuccessActivity::class.java))
                finish()
            }, 1500)

        }, 5000)
    }
}