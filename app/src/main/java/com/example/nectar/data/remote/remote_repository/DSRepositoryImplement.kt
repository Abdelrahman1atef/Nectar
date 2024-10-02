package com.example.nectar.data.remote.remote_repository

import com.example.nectar.data.model.DataResponse
import com.example.nectar.data.remote.api.ApiProvider
import com.example.nectar.data.remote.api.ApiService
import com.example.nectar.data.remote.api.NetworkResource
import com.example.nectar.data.remote.interfaces.DSRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DSRepositoryImplement @Inject constructor(private val apiService: ApiService) : DSRepository, ApiProvider()  {
    override suspend fun getSearchGroceries(): Flow<NetworkResource<List<DataResponse>>> =
       apiRequest { apiService.searchGroceries()}
}