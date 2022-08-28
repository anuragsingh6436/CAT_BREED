package com.example.intuit.repository

import com.example.intuit.model.response.BreedData
import com.example.intuit.network.ApiHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListingRepositoryImpl(val apiHelper: ApiHelper):ListingRepository {


    override fun getCatList(url:String): Flow<List<BreedData>> {
        return flow{
            emit(apiHelper.getBreedList(url))
        }
    }
}