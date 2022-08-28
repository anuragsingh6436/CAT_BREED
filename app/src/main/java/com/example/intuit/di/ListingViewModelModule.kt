package com.example.intuit.di

import com.example.intuit.helper.ListingDataHelper
import com.example.intuit.repository.ListingRepository
import com.example.intuit.viewModel.ListingViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ListingViewModelModule{

    @Provides
    fun provideViewModel(repository: ListingRepository,helper: ListingDataHelper):ListingViewModel {
        return ListingViewModel(repository,helper)
    }
}