package com.example.dapurmamatur.viewmodel

import androidx.lifecycle.*
import com.example.dapurmamatur.data.repository.MainRepository
import com.example.dapurmamatur.data.model.response.CategoriesListResponse
import com.example.dapurmamatur.data.model.response.MealsListResponse
import com.example.dapurmamatur.utilities.DataStatus
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MainRepository) : ViewModel() {

    private val _randomFood: MutableLiveData<List<MealsListResponse.Meal>> = MutableLiveData()
    val randomFood: LiveData<List<MealsListResponse.Meal>> = _randomFood

    private val _categoriesList: MutableLiveData<DataStatus<CategoriesListResponse>> = MutableLiveData()
    val categoriesList: LiveData<DataStatus<CategoriesListResponse>> = _categoriesList

    private val _foodList: MutableLiveData<DataStatus<MealsListResponse>> = MutableLiveData()
    val foodList: LiveData<DataStatus<MealsListResponse>> = _foodList

    fun getRandomFood() = viewModelScope.launch {
        repository.getRandomFood().collect {
            _randomFood.value = it.body()?.meals ?: emptyList()
        }
    }

    fun getCategoriesList() = viewModelScope.launch {
        repository.getCategoriesList().collect {
            _categoriesList.value = it
        }
    }

    fun getFoodsList(letter: String) = viewModelScope.launch {
        repository.getFoodsList(letter).collect {
            _foodList.value = it
        }
    }

    fun getFoodBySearch(query: String) = viewModelScope.launch {
        repository.getFoodsBySearch(query).collect {
            _foodList.value = it
        }
    }

    fun getFoodByCategory(category: String) = viewModelScope.launch {
        repository.getFoodsByCategory(category).collect {
            _foodList.value = it
        }
    }
}