package com.example.V_eat.network

import com.example.V_eat.model.CalorieResponse
import com.example.V_eat.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // NOTE: these endpoints are placeholder examples.
    // Replace paths with real endpoints or mock endpoints you create.

    @GET("swiggy/search")
    suspend fun searchSwiggy(
        @Query("query") query: String
    ): List<Restaurant>

    @GET("zomato/search")
    suspend fun searchZomato(
        @Query("query") query: String
    ): List<Restaurant>

    @GET("nutrition")
    suspend fun getCalories(
        @Query("q") query: String
    ): CalorieResponse
}

