package com.maodev.inovimaps.retrofit

import com.maodev.inovimaps.model.loginRequest
import com.maodev.inovimaps.model.loginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface InoviMapApiService {
    @POST("/login/users")
    suspend fun login(@Body request: loginRequest): loginResponse
}