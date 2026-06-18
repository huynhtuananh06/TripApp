package com.example.dulich

data class AdminOrder(
    val id: String = "",
    val userEmail: String = "",
    val hotelName: String = "",
    val price: Double = 0.0,
    val checkIn: String = "",
    val status: String = "pending"
)