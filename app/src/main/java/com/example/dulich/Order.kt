package com.example.dulich

data class Order(
    val hotelName: String = "",
    val price: String = "",
    val rating: String = "",
    val userId: String = "",
    val status: String = "pending"
)