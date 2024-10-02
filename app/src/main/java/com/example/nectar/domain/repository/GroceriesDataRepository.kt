package com.example.nectar.domain.repository

import com.example.nectar.data.model.DataResponse
import com.example.nectar.data.remote.api.NetworkResource
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    suspend fun getSearchGroceries(): Flow<NetworkResource<List<DataResponse>>>
}