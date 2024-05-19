package com.example.dapurmamatur.di

import android.content.Context
import com.example.dapurmamatur.data.model.db.FoodDatabase
import com.example.dapurmamatur.data.model.db.FoodDao

object DbModule {

    fun provideDatabase(context: Context): FoodDatabase {
        return FoodDatabase.getDatabase(context)
    }

    fun provideFoodDao(database: FoodDatabase): FoodDao {
        return database.foodDao()
    }
}