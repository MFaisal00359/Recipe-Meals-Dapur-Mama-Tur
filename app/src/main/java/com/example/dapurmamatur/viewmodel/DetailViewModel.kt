package com.example.dapurmamatur.viewModel

import androidx.lifecycle.*
import com.example.dapurmamatur.data.repository.MainRepository
import com.example.dapurmamatur.data.model.response.MealsListResponse
import com.example.dapurmamatur.utils.DataStatus
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MainRepository) : ViewModel() {

    private val _foodDetail: MutableLiveData<DataStatus<MealsListResponse>> = MutableLiveData()
    val foodDetail: LiveData<DataStatus<MealsListResponse>> = _foodDetail

    fun getFoodDetail(id: Int) = viewModelScope.launch {
        repository.getFoodDetail(id).collect {
            _foodDetail.value = it
        }
    }
}