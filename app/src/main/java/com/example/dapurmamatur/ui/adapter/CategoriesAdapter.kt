package com.example.dapurmamatur.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dapurmamatur.data.model.response.CategoriesListResponse
import com.example.dapurmamatur.databinding.ItemCategoriesBinding

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private lateinit var binding: ItemCategoriesBinding
    private var categoriesList = emptyList<CategoriesListResponse.Category>()
    private var selectedItem = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    override fun getItemCount() = categoriesList.size

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoriesListResponse.Category) {
            binding.apply {
                itemCategoriesImage.load(item.strCategoryThumb) {
                    crossfade(true)
                    crossfade(500)
                }
                itemCategoriesTxt.text = item.strCategory
                root.setOnClickListener {
                    selectedItem = adapterPosition
                    notifyDataSetChanged()
                    onItemClickListener?.let { it(item) }
                }
            }
        }
    }

    private var onItemClickListener: ((CategoriesListResponse.Category) -> Unit)? = null

    fun setOnItemClickListener(listener: (CategoriesListResponse.Category) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<CategoriesListResponse.Category>) {
        val diffUtil = CategoriesDiffUtil(categoriesList, data)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        categoriesList = data
        diffResult.dispatchUpdatesTo(this)
    }

    class CategoriesDiffUtil(
        private val oldList: List<CategoriesListResponse.Category>,
        private val newList: List<CategoriesListResponse.Category>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
    }
}