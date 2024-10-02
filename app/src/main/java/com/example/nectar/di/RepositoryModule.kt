package com.example.nectar.di

import com.example.movieproject.domain.repository.impl.DataRepositoryImpl
import com.example.movieproject.presentation.home.page_home.HomeViewModel
import com.example.nectar.data.remote.api.ApiService
import com.example.nectar.data.remote.interfaces.DSRepository
import com.example.nectar.data.remote.remote_repository.DSRepositoryImplement
import com.example.nectar.domain.repository.DataRepository
import com.example.nectar.domain.usecase.GetGroceriesDataUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideDataRepository(dSRepository: DSRepository): DataRepository {
        return DataRepositoryImpl(dSRepository)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetGroceriesDataUseCase(dataRepository: DataRepository): GetGroceriesDataUseCase {
        return GetGroceriesDataUseCase(dataRepository)
    }
}

//@Module
//@InstallIn(SingletonComponent::class)
//object ViewModelModule {
//    @Provides
//    @Singleton
//    fun provideViewModel(getGroceriesDataUseCase: GetGroceriesDataUseCase):HomeViewModel{
//        return HomeViewModel(getGroceriesDataUseCase)
//    }
//}