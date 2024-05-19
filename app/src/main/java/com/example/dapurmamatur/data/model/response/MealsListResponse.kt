package com.example.dapurmamatur.data.model.response

import com.google.gson.annotations.SerializedName

data class MealsListResponse(
    @SerializedName("meals")
    val meals: List<Meal>?
) {
    data class Meal(
        @SerializedName("idMeal")
        val idMeal: String?,
        @SerializedName("strMeal")
        val strMeal: String?,
        @SerializedName("strCategory")
        val strCategory: String?,
        @SerializedName("strArea")
        val strArea: String?,
        @SerializedName("strInstructions")
        val strInstructions: String?,
        @SerializedName("strMealThumb")
        val strMealThumb: String?,
        @SerializedName("strTags")
        val strTags: String?,
        @SerializedName("strYoutube")
        val strYoutube: String?,
        @SerializedName("strIngredient1")
        val strIngredient1: String?,
        // Add more ingredients as needed...
    )
}