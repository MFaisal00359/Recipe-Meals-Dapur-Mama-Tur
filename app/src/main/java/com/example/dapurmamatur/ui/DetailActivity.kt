package com.example.dapurmamatur.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.dapurmamatur.ui.adapter.IngredientsAdapter
import com.example.dapurmamatur.data.model.response.MealsListResponse
import com.example.dapurmamatur.databinding.ActivityDetailBinding
import com.example.dapurmamatur.di.ApiModule
import com.example.dapurmamatur.di.DbModule
import com.example.dapurmamatur.data.repository.MainRepository
import com.example.dapurmamatur.utils.DataStatus
import com.example.dapurmamatur.viewModel.DetailViewModel
import com.example.dapurmamatur.viewModel.DetailViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var ingredientsAdapter: IngredientsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = MainRepository(
            ApiModule.provideApiService(),
            DbModule.provideFoodDao(DbModule.provideDatabase(applicationContext))
        )

        detailViewModel = ViewModelProvider(this, DetailViewModelFactory(repository)).get(DetailViewModel::class.java)

        val mealId = intent.getStringExtra("MEAL_ID")?.toInt() ?: -1
        if (mealId != -1) {
            detailViewModel.getFoodDetail(mealId)
        }

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        ingredientsAdapter = IngredientsAdapter()
        binding.ingredientsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter = ingredientsAdapter
        }
    }

    private fun setupObservers() {
        detailViewModel.foodDetail.observe(this, Observer { status ->
            when (status.status) {
                DataStatus.Status.LOADING -> {
                    // Show loading
                }
                DataStatus.Status.SUCCESS -> {
                    status.data?.let {
                        val meal = it.meals?.firstOrNull()
                        meal?.let { bindDetails(it) }
                    }
                }
                DataStatus.Status.ERROR -> {
                    // Show error
                }
            }
        })
    }

    private fun bindDetails(meal: MealsListResponse.Meal) {
        binding.apply {
            recipeImage.load(meal.strMealThumb)
            recipeTitle.text = meal.strMeal
            recipeCatgory.text = meal.strCategory
            recipeInstructions.text = meal.strInstructions
            // Bind ingredients
            ingredientsAdapter.setData(getIngredientsList(meal))
        }
    }

    private fun getIngredientsList(meal: MealsListResponse.Meal): List<String> {
        val ingredients = mutableListOf<String>()
        if (!meal.strIngredient1.isNullOrEmpty()) ingredients.add("${meal.strIngredient1} - ${meal.strMeasure1}")
        if (!meal.strIngredient2.isNullOrEmpty()) ingredients.add("${meal.strIngredient2} - ${meal.strMeasure2}")
        if (!meal.strIngredient3.isNullOrEmpty()) ingredients.add("${meal.strIngredient3} - ${meal.strMeasure3}")
        if (!meal.strIngredient4.isNullOrEmpty()) ingredients.add("${meal.strIngredient4} - ${meal.strMeasure4}")
        if (!meal.strIngredient5.isNullOrEmpty()) ingredients.add("${meal.strIngredient5} - ${meal.strMeasure5}")
        // Add more ingredients as needed
        return ingredients
    }
}
