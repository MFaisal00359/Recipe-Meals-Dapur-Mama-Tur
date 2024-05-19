package com.example.dapurmamatur.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dapurmamatur.adapter.CategoriesAdapter
import com.example.dapurmamatur.adapter.FoodsAdapter
import com.example.dapurmamatur.data.repository.MainRepository
import com.example.dapurmamatur.databinding.ActivityHomeBinding
import com.example.dapurmamatur.di.ApiModule
import com.example.dapurmamatur.di.DbModule
import com.example.dapurmamatur.utils.DataStatus
import com.example.dapurmamatur.viewModel.HomeViewModel
import com.example.dapurmamatur.viewModel.HomeViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(MainRepository(ApiModule.provideApiService(), DbModule.provideFoodDao(DbModule.provideDatabase(applicationContext))))
    }
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var foodsAdapter: FoodsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerViews()
        setupObservers()

        homeViewModel.getCategoriesList()
        homeViewModel.getRandomFood()
    }

    private fun setupRecyclerViews() {
        categoriesAdapter = CategoriesAdapter()
        binding.categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoriesAdapter
        }

        foodsAdapter = FoodsAdapter()
        binding.recyclerViewRecipes.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = foodsAdapter
        }
    }

    private fun setupObservers() {
        homeViewModel.categoriesList.observe(this, Observer { status ->
            when (status.status) {
                DataStatus.Status.LOADING -> {
                    // Show loading
                }
                DataStatus.Status.SUCCESS -> {
                    status.data?.let {
                        categoriesAdapter.setData(it.categories)
                    }
                }
                DataStatus.Status.ERROR -> {
                    // Show error
                }
            }
        })

        homeViewModel.randomFood.observe(this, Observer { meals ->
            foodsAdapter.setData(meals)
        })
    }
}