package com.example.nectar.di

import com.example.nectar.data.remote.api.ApiService
import com.example.nectar.data.remote.interfaces.DSRepository
import com.example.nectar.data.remote.remote_repository.DSRepositoryImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DSModule {
    @Provides
    @Singleton
    fun provideDSRepository(apiService: ApiService): DSRepository {
        return DSRepositoryImplement(apiService)
    }
}