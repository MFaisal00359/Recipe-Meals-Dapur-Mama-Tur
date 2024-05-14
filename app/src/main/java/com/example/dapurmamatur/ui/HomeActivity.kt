package com.example.dapurmamatur.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurmamatur.R
import com.example.dapurmamatur.data.model.Recipe
import com.example.dapurmamatur.RecipeAdapter

class HomeActivity : AppCompatActivity() {
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewRecipes)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        recipeAdapter = RecipeAdapter(emptyList())

        val dummyRecipes = listOf(
            Recipe(R.drawable.lamb, "Recipe 1"),
            Recipe(R.drawable.potato, "Recipe 2"),
            Recipe(R.drawable.salmon, "Recipe 3"),
            Recipe(R.drawable.mie, "Recipe 4"),
            Recipe(R.drawable.potato, "Recipe 5"),
            Recipe(R.drawable.salmon, "Recipe 6"),
            Recipe(R.drawable.lamb, "Recipe 7"),
            Recipe(R.drawable.mie, "Recipe 8"),
        )

        recipeAdapter.updateData(dummyRecipes)
        recyclerView.adapter = recipeAdapter

        findViewById<View>(R.id.exploreTitle).setOnClickListener {
            startActivity(Intent(this, FavoritActivity::class.java))
        }

        findViewById<View>(R.id.profileImage).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
