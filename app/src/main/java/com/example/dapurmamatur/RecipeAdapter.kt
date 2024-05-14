package com.example.dapurmamatur

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurmamatur.data.model.Recipe

class RecipeAdapter(private var recipeList: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = recipeList[position]

        holder.imageView.setImageResource(currentItem.imageResId)
        holder.textViewTitle.text = currentItem.title
    }

    override fun getItemCount() = recipeList.size

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recipeImage)
        val textViewTitle: TextView = itemView.findViewById(R.id.recipeTitle)
    }

    // Update ke Adapter
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newRecipeList: List<Recipe>) {
        recipeList = newRecipeList
        notifyDataSetChanged()
    }
}
