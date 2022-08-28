package com.example.intuit.network

class ApiHelper(private val apiService: ApiService) {

    suspend fun getBreedList(url:String) = apiService.getBreedList(url)
    suspend fun getBreedDetail(url:String) = apiService.getBreedDetail(url)
}