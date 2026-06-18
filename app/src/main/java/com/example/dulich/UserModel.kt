package com.example.dulich

data class UserModel(
    val email: String = "",
    val createdAt: String = "",
    val lastLogin: String = "",
    val disabled: Boolean = false
)