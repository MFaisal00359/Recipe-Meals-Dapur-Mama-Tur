package com.example.dapurmamatur.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dapurmamatur.databinding.ItemRecipeBinding
import com.example.dapurmamatur.data.model.db.FoodEntity

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private var favoriteList = emptyList<FoodEntity>()
    private var onItemClickListener: ((FoodEntity) -> Unit)? = null

    fun setOnItemClickListener(listener: (FoodEntity) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<FoodEntity>) {
        val diffUtil = FavoriteDiffUtil(favoriteList, data)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        favoriteList = data
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FoodEntity) {
            binding.apply {
                recipeTitle.text = item.name
                recipeImage.load(item.description) {
                    crossfade(true)
                    crossfade(500)
                }
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
        holder.bind(favoriteList[position])
    }

    override fun getItemCount() = favoriteList.size

    class FavoriteDiffUtil(
        private val oldList: List<FoodEntity>,
        private val newList: List<FoodEntity>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].id == newList[newItemPosition].id
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
    }
}
