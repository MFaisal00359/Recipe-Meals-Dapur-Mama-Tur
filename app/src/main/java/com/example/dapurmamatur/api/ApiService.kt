package com.example.dapurmamatur.api

import com.example.dapurmamatur.data.model.response.CategoriesListResponse
import com.example.dapurmamatur.data.model.response.MealsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("random.php")
    suspend fun getFoodRandom() : Response<MealsListResponse>

    @GET("categories.php")
    suspend fun getCategoriesList() : Response<CategoriesListResponse>

    @GET("search.php")
    suspend fun getFoodList(@Query("f") latter : String) : Response<MealsListResponse>

    @GET("search.php")
    suspend fun searchList(@Query("s") latter : String) : Response<MealsListResponse>

    @GET("filter.php")
    suspend fun filterList(@Query("c") latter : String) : Response<MealsListResponse>

    @GET("lookup.php")
    suspend fun getFoodDetails(@Query("i") id : Int) : Response<MealsListResponse>

}