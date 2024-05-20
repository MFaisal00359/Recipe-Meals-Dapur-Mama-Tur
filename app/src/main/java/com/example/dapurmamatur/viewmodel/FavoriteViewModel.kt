package com.example.dapurmamatur.viewModel

import androidx.lifecycle.*
import com.example.dapurmamatur.data.model.db.FoodEntity
import com.example.dapurmamatur.data.repository.MainRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: MainRepository) : ViewModel() {

    val favoriteList: LiveData<List<FoodEntity>> = repository.getDbFoodList().asLiveData()

    fun saveFavorite(foodEntity: FoodEntity) = viewModelScope.launch {
        repository.saveFood(foodEntity)
    }

    fun deleteFavorite(foodEntity: FoodEntity) = viewModelScope.launch {
        repository.deleteFood(foodEntity)
    }

    fun isFavorite(id: Int): LiveData<Boolean> = repository.existsFood(id.toString()).asLiveData()
}
