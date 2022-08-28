package com.example.intuit.repository

import com.example.intuit.model.response.BreedData
import kotlinx.coroutines.flow.Flow

interface ListingRepository {

    fun getCatList(url:String): Flow<List<BreedData>>

}