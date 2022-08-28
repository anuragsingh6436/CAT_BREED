package com.example.intuit.di

import com.example.intuit.network.ApiHelper
import com.example.intuit.network.RetrofitBuilder
import com.example.intuit.repository.ListingRepository
import com.example.intuit.repository.ListingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryProvider {

    @Provides
    fun provideListingRepository(): ListingRepository {
        return ListingRepositoryImpl(ApiHelper(RetrofitBuilder.apiService))
    }

}