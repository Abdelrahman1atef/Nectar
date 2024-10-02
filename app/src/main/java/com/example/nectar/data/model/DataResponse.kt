package com.example.nectar.data.model

import com.google.gson.annotations.SerializedName


data class DataResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Double,
    @SerializedName("image") val image: String,

)


