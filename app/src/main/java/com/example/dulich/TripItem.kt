package com.example.dulich

sealed class TripItem {
    data class Header(val title: String) : TripItem()
    data class TourItem(val name: String, val image: Int, val price: String, val rating: String) : TripItem()
}