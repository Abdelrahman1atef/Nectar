package com.example.nectar.data.remote.api

import com.example.nectar.data.model.DataResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    companion object {
        fun createService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    }
    @GET(groceriesEndPoint)
    suspend fun searchGroceries(): Response<List<DataResponse>>
}