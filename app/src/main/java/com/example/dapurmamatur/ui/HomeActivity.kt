package com.example.dapurmamatur.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dapurmamatur.R
import com.example.dapurmamatur.ui.adapter.CategoriesAdapter
import com.example.dapurmamatur.ui.adapter.FoodsAdapter
import com.example.dapurmamatur.databinding.ActivityHomeBinding
import com.example.dapurmamatur.di.ApiModule
import com.example.dapurmamatur.di.DbModule
import com.example.dapurmamatur.di.NetworkModule
import com.example.dapurmamatur.data.repository.MainRepository
import com.example.dapurmamatur.utilities.CheckConnection
import com.example.dapurmamatur.utilities.DataStatus
import com.example.dapurmamatur.viewmodel.HomeViewModel
import com.example.dapurmamatur.viewmodel.HomeViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var foodsAdapter: FoodsAdapter
    private lateinit var checkConnection: CheckConnection
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = MainRepository(
            ApiModule.provideApiService(),
            DbModule.provideFoodDao(DbModule.provideDatabase(applicationContext))
        )

        homeViewModel = ViewModelProvider(this, HomeViewModelFactory(repository))[HomeViewModel::class.java]

        auth = FirebaseAuth.getInstance()

        setupRecyclerViews()
        setupObservers()
        setupSearchInput()
        setupConnectionObserver()
        setupBottomNavigation()

        homeViewModel.getCategoriesList()
        homeViewModel.getFoodsList("b")

        val user = auth.currentUser
        user?.let {
            binding.profileName.text = it.displayName
        }

        binding.profileLayout.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun setupRecyclerViews() {
        categoriesAdapter = CategoriesAdapter().apply {
            setOnItemClickListener { category ->
                homeViewModel.getFoodByCategory(category.strCategory ?: "")
            }
        }

        binding.categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoriesAdapter
        }

        foodsAdapter = FoodsAdapter().apply {
            setOnItemClickListener { meal ->
                val intent = Intent(this@HomeActivity, DetailActivity::class.java).apply {
                    putExtra("MEAL_ID", meal.idMeal)
                }
                startActivity(intent)
            }
        }

        binding.recyclerViewRecipes.apply {
            layoutManager = GridLayoutManager(this@HomeActivity, 2)
            adapter = foodsAdapter
        }
    }

    private fun setupObservers() {
        homeViewModel.categoriesList.observe(this) { status ->
            when (status.status) {
                DataStatus.Status.LOADING -> binding.homeCategoryLoading.visibility = View.VISIBLE
                DataStatus.Status.SUCCESS -> {
                    binding.homeCategoryLoading.visibility = View.GONE
                    status.data?.let { categoriesAdapter.setData(it.categories) }
                }
                DataStatus.Status.ERROR -> binding.homeCategoryLoading.visibility = View.GONE
            }
        }

        homeViewModel.foodList.observe(this) { status ->
            when (status.status) {
                DataStatus.Status.LOADING -> binding.homeFoodsLoading.visibility = View.VISIBLE
                DataStatus.Status.SUCCESS -> {
                    binding.homeFoodsLoading.visibility = View.GONE
                    status.data?.let { foodsAdapter.setData(it.meals ?: emptyList()) }
                }
                DataStatus.Status.ERROR -> binding.homeFoodsLoading.visibility = View.GONE
            }
        }
    }

    private fun setupSearchInput() {
        binding.SearchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let {
                    if (it.isNotEmpty()) {
                        homeViewModel.getFoodBySearch(it)
                    } else {
                        homeViewModel.getFoodsList("b")
                    }
                }
            }
        })
    }

    private fun setupConnectionObserver() {
        checkConnection = CheckConnection(NetworkModule.provideConnectivityManager(this))
        checkConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.viewOffline.visibility = View.GONE
                binding.homeDissconect.visibility = View.GONE
                binding.viewContent.visibility = View.VISIBLE
            } else {
                binding.viewOffline.visibility = View.VISIBLE
                binding.homeDissconect.visibility = View.VISIBLE
                binding.viewContent.visibility = View.GONE
            }
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> true
                R.id.navigation_favorite -> {
                    startActivity(Intent(this, FavoriteActivity::class.java))
                    true
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.navigation_home
    }
}
