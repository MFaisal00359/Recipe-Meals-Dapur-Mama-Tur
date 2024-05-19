package com.example.dapurmamatur.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dapurmamatur.data.model.response.MealsListResponse
import com.example.dapurmamatur.databinding.ItemRecipeBinding

class FoodsAdapter : RecyclerView.Adapter<FoodsAdapter.ViewHolder>() {

    private var foodsList = emptyList<MealsListResponse.Meal>()
    private var onItemClickListener: ((MealsListResponse.Meal) -> Unit)? = null

    fun setOnItemClickListener(listener: (MealsListResponse.Meal) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<MealsListResponse.Meal>) {
        val diffUtil = FoodsDiffUtil(foodsList, data)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        foodsList = data
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MealsListResponse.Meal) {
            binding.apply {
                recipeImage.load(item.strMealThumb)
                recipeTitle.text = item.strMeal
                root.setOnClickListener {
                    onItemClickListener?.let { it(item) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foodsList[position])
    }

    override fun getItemCount(): Int = foodsList.size

    class FoodsDiffUtil(
        private val oldList: List<MealsListResponse.Meal>,
        private val newList: List<MealsListResponse.Meal>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
    }
}