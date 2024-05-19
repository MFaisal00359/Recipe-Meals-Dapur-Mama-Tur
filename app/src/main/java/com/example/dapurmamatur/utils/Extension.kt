package com.example.dapurmamatur.utils

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurmamatur.R

fun Spinner.setupListWithAdapter(list: List<String>, callback: (String) -> Unit) {
    val adapter = ArrayAdapter(context, R.layout.item_spinner, list)
    adapter.setDropDownViewResource(R.layout.item_spinner_list)
    this.adapter = adapter
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            callback(list[position])
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
}

fun View.isVisible(isShowLoading: Boolean, container: View) {
    visibility = if (isShowLoading) View.VISIBLE else View.GONE
    container.visibility = if (isShowLoading) View.GONE else View.VISIBLE
}

fun RecyclerView.setupRecyclerView(layoutManager: RecyclerView.LayoutManager, adapter: RecyclerView.Adapter<*>) {
    this.layoutManager = layoutManager
    this.setHasFixedSize(true)
    this.adapter = adapter
}