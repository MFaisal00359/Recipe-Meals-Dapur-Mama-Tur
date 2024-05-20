package com.example.dapurmamatur.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dapurmamatur.databinding.ItemIngredientBinding

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    private var ingredientsList = emptyList<Pair<String, String?>>()

    fun setData(data: List<Pair<String, String?>>) {
        ingredientsList = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemIngredientBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Pair<String, String?>) {
            binding.apply {
                ingredientName.text = "${ingredient.first} - ${ingredient.second}"
                val imageUrl = "https://www.themealdb.com/images/ingredients/${ingredient.first}.png"
                ingredientImage.load(imageUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ingredientsList[position])
    }

    override fun getItemCount(): Int = ingredientsList.size
}
