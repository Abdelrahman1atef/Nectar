package com.example.nectar.data.remote.interfaces

import com.example.nectar.data.model.DataResponse
import com.example.nectar.data.remote.api.NetworkResource
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface DSRepository {
    suspend fun getSearchGroceries(): Flow<NetworkResource<List<DataResponse>>>
}