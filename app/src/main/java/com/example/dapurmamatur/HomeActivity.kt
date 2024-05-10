package com.example.dapurmamatur

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Set Padding SysteBars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Init RecyclerView (Buat List)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewRecipes)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        // Inisialisasi Adapter
        recipeAdapter = RecipeAdapter(emptyList())

        // Data Sampel Dummy
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

        // Update Dummy
        recipeAdapter.updateData(dummyRecipes)
        recyclerView.adapter = recipeAdapter
    }
}
