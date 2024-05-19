package com.example.dapurmamatur.viewModel

import androidx.lifecycle.*
import com.example.dapurmamatur.data.model.db.FoodEntity
import com.example.dapurmamatur.data.repository.MainRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: MainRepository) : ViewModel() {

    val favoriteList: LiveData<List<FoodEntity>> = repository.getDbFoodList().asLiveData()

    fun saveFood(foodEntity: FoodEntity) = viewModelScope.launch {
        repository.saveFood(foodEntity)
    }

    fun deleteFood(foodEntity: FoodEntity) = viewModelScope.launch {
        repository.deleteFood(foodEntity)
    }

    fun existsFood(id: Int): LiveData<Boolean> = repository.existsFood(id).asLiveData()
}