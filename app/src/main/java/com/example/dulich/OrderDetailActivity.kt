package com.example.dulich

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        findViewById<TextView>(R.id.txtName).text =
            intent.getStringExtra("name")

        findViewById<TextView>(R.id.txtPrice).text =
            intent.getStringExtra("price")

        findViewById<TextView>(R.id.txtRating).text =
            "⭐ ${intent.getStringExtra("rating")}"
    }
}