package com.example.dulich

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HotelPaymentActivity : AppCompatActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_hotel_payment
        )

        window.statusBarColor =
            Color.parseColor("#0B5CFF")

        val hotelImage =
            findViewById<ImageView>(
                R.id.hotelImage
            )

        val txtHotelName =
            findViewById<TextView>(
                R.id.txtHotelName
            )

        val txtAddress =
            findViewById<TextView>(
                R.id.txtAddress
            )

        val txtPrice =
            findViewById<TextView>(
                R.id.txtPrice
            )

        val txtOldPrice =
            findViewById<TextView>(
                R.id.txtOldPrice
            )

        val btnPayment =
            findViewById<Button>(
                R.id.btnPayment
            )

        val facilityLayout =
            findViewById<LinearLayout>(
                R.id.facilityLayout
            )

        // Dữ liệu khách sạn
        hotelImage.setImageResource(
            R.drawable.bana1
        )

        txtHotelName.text =
            "Khách Sạn King Sài Gòn"

        txtAddress.text =
            "25/22 Cửu Long, Tân Bình, TP.HCM"

        txtPrice.text =
            "379.000đ"

        txtOldPrice.text =
            "969.000đ"

        // Tiện nghi
        addFacility(
            facilityLayout,
            "WiFi",
            "Miễn phí"
        )

        addFacility(
            facilityLayout,
            "Đậu xe",
            "Miễn phí"
        )

        addFacility(
            facilityLayout,
            "Hồ bơi",
            "Có"
        )

        addFacility(
            facilityLayout,
            "Lễ tân",
            "24/7"
        )

        btnPayment.setOnClickListener {

            Toast.makeText(
                this,
                "Thanh toán thành công",
                Toast.LENGTH_SHORT
            ).show()

        }

    }

    private fun addFacility(
        layout: LinearLayout,
        name: String,
        value: String
    ) {

        val item =
            layoutInflater.inflate(
                R.layout.item_facility,
                null
            )

        val txtName =
            item.findViewById<TextView>(
                R.id.txtFacilityName
            )

        val txtValue =
            item.findViewById<TextView>(
                R.id.txtFacilityValue
            )

        txtName.text = name
        txtValue.text = value

        layout.addView(item)

    }

}