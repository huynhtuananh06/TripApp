package com.example.dulich

data class Order(
    val orderId: String = "",
    val hotelName: String = "",
    val price: Double = 0.0,
    val rating: String = "",
    val userId: String = "",
    var quantity: Double = 1.0,
    val status: String = "pending",
    val checkIn: String = "",
    val bookingStatus: String = "Chờ xác nhận",

)