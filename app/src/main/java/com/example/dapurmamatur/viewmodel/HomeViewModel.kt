package com.example.dapurmamatur.viewModel

import androidx.lifecycle.*
import com.example.dapurmamatur.data.model.response.CategoriesListResponse
import com.example.dapurmamatur.data.model.response.MealsListResponse
import com.example.dapurmamatur.data.repository.MainRepository
import com.example.dapurmamatur.utils.DataStatus
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MainRepository) : ViewModel() {

    private val _randomFood: MutableLiveData<List<MealsListResponse.Meal>> = MutableLiveData()
    val randomFood: LiveData<List<MealsListResponse.Meal>> = _randomFood

    fun getRandomFood() = viewModelScope.launch {
        repository.getRandomFood().collect {
            _randomFood.value = it.body()?.meals ?: emptyList()
        }
    }

    private val _categoriesList: MutableLiveData<DataStatus<CategoriesListResponse>> = MutableLiveData()
    val categoriesList: LiveData<DataStatus<CategoriesListResponse>> = _categoriesList

    fun getCategoriesList() = viewModelScope.launch {
        repository.getCategoriesList().collect {
            _categoriesList.value = it
        }
    }

    val filtersListData = MutableLiveData<MutableList<Char>>()
    fun loadFilterList() = viewModelScope.launch {
        val letters = ('A'..'Z').toMutableList()
        filtersListData.value = letters
    }

    private val _foodList: MutableLiveData<DataStatus<MealsListResponse>> = MutableLiveData()
    val foodList: LiveData<DataStatus<MealsListResponse>> = _foodList

    fun getFoodsList(letter: String) = viewModelScope.launch {
        repository.getFoodsList(letter).collect {
            _foodList.value = it
        }
    }

//    fun getFoodBySearch(letter: String) = viewModelScope.launch {
//        repository.getFoodsBySearch(letter).collect {
//            _foodList.value = it
//        }
//    }
//
//    fun getFoodByCategory(letter: String) = viewModelScope.launch {
//        repository.getFoodsByCategory(letter).collect {
//            _foodList.value = it
//        }
//    }
}

class HomeViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}