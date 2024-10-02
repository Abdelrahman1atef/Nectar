package com.example.movieproject.domain.repository.impl


import com.example.nectar.data.model.DataResponse
import com.example.nectar.data.remote.api.NetworkResource
import com.example.nectar.data.remote.interfaces.DSRepository
import com.example.nectar.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val groceriesDS: DSRepository,
) : DataRepository {

    override suspend fun getSearchGroceries(): Flow<NetworkResource<List<DataResponse>>> =
        groceriesDS.getSearchGroceries()
}
