package com.example.dulich

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HotelDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)

        // Nhận tên khách sạn
        val hotelName = intent.getStringExtra("hotelName")

        // Tìm khách sạn trong Repository
        val hotel = HotelRepository.getHotel(hotelName ?: "")

        if (hotel == null) {
            finish()
            return
        }

        //==========================
        // Ánh xạ View
        //==========================
        val imgHotel = findViewById<ImageView>(R.id.imgHotel)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtRating = findViewById<TextView>(R.id.txtRating)
        val txtPrice = findViewById<TextView>(R.id.txtPrice)
        val txtAddress = findViewById<TextView>(R.id.txtAddress)

        val txtDescription = findViewById<TextView>(R.id.txtDescription)

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtReview = findViewById<TextView>(R.id.txtReview)

        val txtNear1 = findViewById<TextView>(R.id.txtNear1)
        val txtNear2 = findViewById<TextView>(R.id.txtNear2)
        val txtNear3 = findViewById<TextView>(R.id.txtNear3)

        val txtFacility1 = findViewById<TextView>(R.id.txtFacility1)
        val txtFacility2 = findViewById<TextView>(R.id.txtFacility2)
        val txtFacility3 = findViewById<TextView>(R.id.txtFacility3)

        val txtCheckIn = findViewById<TextView>(R.id.txtCheckIn)
        val txtCheckOut = findViewById<TextView>(R.id.txtCheckOut)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        //==========================
        // Hiển thị dữ liệu
        //==========================
        imgHotel.setImageResource(hotel.image)

        txtName.text = hotel.name

        txtRating.text = "⭐ ${hotel.rating}"

        txtPrice.text = "%,d VNĐ/đêm".format(hotel.price)

        txtAddress.text = "📍 ${hotel.address}"

        txtDescription.text = hotel.description

        txtScore.text = "Điểm đánh giá: ${hotel.score}"

        txtReview.text = hotel.review
        txtNear1.text = "📍 ${hotel.near1}"
        txtNear2.text = "📍 ${hotel.near2}"
        txtNear3.text = "📍 ${hotel.near3}"

        txtFacility1.text = "✔ ${hotel.facility1}"
        txtFacility2.text = "✔ ${hotel.facility2}"
        txtFacility3.text = "✔ ${hotel.facility3}"

        txtCheckIn.text = "🕑 Check-in: 14:00"
        txtCheckOut.text = "🕛 Check-out: 12:00"

        txtNear1.text = "📍 ${hotel.near1}"
        txtNear2.text = "📍 ${hotel.near2}"
        txtNear3.text = "📍 ${hotel.near3}"

        txtFacility1.text = "✓ ${hotel.facility1}"
        txtFacility2.text = "✓ ${hotel.facility2}"
        txtFacility3.text = "✓ ${hotel.facility3}"
        txtCheckIn.text = "🕑 Check-in: 14:00"

        txtCheckOut.text = "🕛 Check-out: 12:00"

        //==========================
        // Quay lại
        //==========================
        btnBack.setOnClickListener {
            finish()
        }
    }
}