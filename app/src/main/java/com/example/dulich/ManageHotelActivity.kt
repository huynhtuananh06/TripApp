package com.example.dulich

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ManageHotelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_hotel)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnAdd = findViewById<FloatingActionButton>(R.id.fabAddHotel)
        val recycler = findViewById<RecyclerView>(R.id.recyclerHotel)

        recycler.layoutManager = LinearLayoutManager(this)

        recycler.adapter = ManageHotelAdapter(
            HotelRepository.hotels
        )

        btnBack.setOnClickListener {
            finish()
        }

        btnAdd.setOnClickListener {
            // mở màn thêm hotel
        }

    }
}