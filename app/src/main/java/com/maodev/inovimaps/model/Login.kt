package com.maodev.inovimaps.model


//LoginRequest
data class loginRequest(
    val email: String,
    val password: String
)

//LoginResponse
data class loginResponse(
    val message: String
)