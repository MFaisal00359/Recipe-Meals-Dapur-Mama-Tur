package com.example.dapurmamatur.data.repository

import com.example.dapurmamatur.api.ApiService
import com.example.dapurmamatur.data.model.db.FoodDao
import com.example.dapurmamatur.data.model.response.CategoriesListResponse
import com.example.dapurmamatur.data.model.response.MealsListResponse
import com.example.dapurmamatur.data.model.db.FoodEntity
import com.example.dapurmamatur.utils.DataStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class MainRepository(private val apiService: ApiService, private val dao: FoodDao) {

    suspend fun getRandomFood(): Flow<Response<MealsListResponse>> {
        return flow {
            emit(apiService.getFoodRandom())
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCategoriesList(): Flow<DataStatus<CategoriesListResponse>> {
        return flow {
            emit(DataStatus.loading())
            val response = apiService.getCategoriesList()
            if (response.isSuccessful) {
                emit(DataStatus.success(response.body()))
            } else {
                emit(DataStatus.error("Error fetching categories"))
            }
        }.catch {
            emit(DataStatus.error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getFoodsList(letter: String): Flow<DataStatus<MealsListResponse>> {
        return flow {
            emit(DataStatus.loading())
            val response = apiService.getFoodList(letter)
            if (response.isSuccessful) {
                emit(DataStatus.success(response.body()))
            } else {
                emit(DataStatus.error("Error fetching foods"))
            }
        }.catch {
            emit(DataStatus.error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getFoodsBySearch(query: String): Flow<DataStatus<MealsListResponse>> {
        return flow {
            emit(DataStatus.loading())
            val response = apiService.searchList(query)
            if (response.isSuccessful) {
                emit(DataStatus.success(response.body()))
            } else {
                emit(DataStatus.error("Error searching foods"))
            }
        }.catch {
            emit(DataStatus.error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getFoodsByCategory(category: String): Flow<DataStatus<MealsListResponse>> {
        return flow {
            emit(DataStatus.loading())
            val response = apiService.filterList(category)
            if (response.isSuccessful) {
                emit(DataStatus.success(response.body()))
            } else {
                emit(DataStatus.error("Error fetching foods by category"))
            }
        }.catch {
            emit(DataStatus.error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getFoodDetail(id: Int): Flow<DataStatus<MealsListResponse>> {
        return flow {
            emit(DataStatus.loading())
            val response = apiService.getFoodDetails(id)
            if (response.isSuccessful) {
                emit(DataStatus.success(response.body()))
            } else {
                emit(DataStatus.error("Error fetching food detail"))
            }
        }.catch {
            emit(DataStatus.error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun saveFood(entity: FoodEntity) = dao.saveFood(entity)
    suspend fun deleteFood(entity: FoodEntity) = dao.deleteFood(entity)
    fun existsFood(id: String?) = dao.existsFood(id.toString())
    fun getDbFoodList() = dao.getAllFoods()
}
