package com.example.dapurmamatur.data.model.db

import androidx.room.*
import com.example.dapurmamatur.db.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFood(entity: FoodEntity)

    @Delete
    suspend fun deleteFood(entity: FoodEntity)

    @Query("SELECT * FROM food_table")
    fun getAllFoods(): Flow<List<FoodEntity>>

    @Query("SELECT EXISTS (SELECT 1 FROM food_table WHERE id = :id)")
    fun existsFood(id: Int): Flow<Boolean>
}