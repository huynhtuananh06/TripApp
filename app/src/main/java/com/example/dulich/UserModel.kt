package com.example.dulich

data class UserModel(
    val uid: String,
    val email: String,
    val createdAt: String,
    val lastLogin: String,
    var disabled: Boolean
)