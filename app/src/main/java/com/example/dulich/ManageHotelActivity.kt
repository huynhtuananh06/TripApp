package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ManageHotelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_hotel)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnAdd = findViewById<Button>(R.id.btnAddHotel)
        val btnDelete = findViewById<Button>(R.id.btnDeleteHotel)

        btnBack.setOnClickListener {
            finish()
        }

        btnAdd.setOnClickListener {
            // mở màn thêm hotel
        }

        btnDelete.setOnClickListener {
            // mở màn xóa hotel
        }
    }
}