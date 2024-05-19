package com.example.dapurmamatur.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dapurmamatur.ui.adapter.FavoriteAdapter
import com.example.dapurmamatur.databinding.ActivityFavoriteBinding
import com.example.dapurmamatur.di.ApiModule
import com.example.dapurmamatur.di.DbModule
import com.example.dapurmamatur.data.repository.MainRepository
import com.example.dapurmamatur.viewModel.FavoriteViewModel
import com.example.dapurmamatur.viewModel.FavoriteViewModelFactory

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = MainRepository(
            ApiModule.provideApiService(),
            DbModule.provideFoodDao(DbModule.provideDatabase(applicationContext))
        )

        favoriteViewModel = ViewModelProvider(this, FavoriteViewModelFactory(repository)).get(FavoriteViewModel::class.java)

        setupRecyclerView()
        setupObservers()

        favoriteViewModel.favoriteList.observe(this, Observer {
            favoriteAdapter.setData(it)
        })
    }

    private fun setupRecyclerView() {
        favoriteAdapter = FavoriteAdapter()
        binding.recyclerViewRecipes.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = favoriteAdapter
        }
    }

    private fun setupObservers() {
        // Observe LiveData
    }
}