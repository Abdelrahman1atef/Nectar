package com.example.nectar.domain.usecase

import com.example.nectar.domain.repository.DataRepository


class GetGroceriesDataUseCase(private val groceriesDataRepository: DataRepository) {
    suspend fun getGroceriesData() = groceriesDataRepository.getSearchGroceries()
}