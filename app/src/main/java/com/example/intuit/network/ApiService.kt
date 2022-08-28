package com.example.intuit.network

import com.example.intuit.model.response.BreedData
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getBreedList(@Url url:String): List<BreedData>

    @GET
    suspend fun getBreedDetail(@Url url:String): List<BreedData>
}