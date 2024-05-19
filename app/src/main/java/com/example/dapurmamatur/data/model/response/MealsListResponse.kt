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
        val strIngredient1: String?, // Minced Beef
        @SerializedName("strIngredient10")
        val strIngredient10: String?,
        @SerializedName("strIngredient11")
        val strIngredient11: String?,
        @SerializedName("strIngredient12")
        val strIngredient12: String?,
        @SerializedName("strIngredient13")
        val strIngredient13: String?,
        @SerializedName("strIngredient14")
        val strIngredient14: String?,
        @SerializedName("strIngredient15")
        val strIngredient15: String?,
        @SerializedName("strIngredient16")
        val strIngredient16: String?,
        @SerializedName("strIngredient17")
        val strIngredient17: String?,
        @SerializedName("strIngredient18")
        val strIngredient18: String?,
        @SerializedName("strIngredient19")
        val strIngredient19: String?,
        @SerializedName("strIngredient2")
        val strIngredient2: String?, // Onion
        @SerializedName("strIngredient20")
        val strIngredient20: String?,
        @SerializedName("strIngredient3")
        val strIngredient3: String?, // Eggs
        @SerializedName("strIngredient4")
        val strIngredient4: String?, // Chilli
        @SerializedName("strIngredient5")
        val strIngredient5: String?, // Baguette
        @SerializedName("strIngredient6")
        val strIngredient6: String?, // Salt
        @SerializedName("strIngredient7")
        val strIngredient7: String?, // Pepper
        @SerializedName("strIngredient8")
        val strIngredient8: String?, // Mayonnaise
        @SerializedName("strIngredient9")
        val strIngredient9: String?,
        @SerializedName("strMeasure1")
        val strMeasure1: String?, // 1/4 lb
        @SerializedName("strMeasure10")
        val strMeasure10: String?,
        @SerializedName("strMeasure11")
        val strMeasure11: String?,
        @SerializedName("strMeasure12")
        val strMeasure12: String?,
        @SerializedName("strMeasure13")
        val strMeasure13: String?,
        @SerializedName("strMeasure14")
        val strMeasure14: String?,
        @SerializedName("strMeasure15")
        val strMeasure15: String?,
        @SerializedName("strMeasure16")
        val strMeasure16: String?,
        @SerializedName("strMeasure17")
        val strMeasure17: String?,
        @SerializedName("strMeasure18")
        val strMeasure18: String?,
        @SerializedName("strMeasure19")
        val strMeasure19: String?,
        @SerializedName("strMeasure2")
        val strMeasure2: String?, // 1
        @SerializedName("strMeasure20")
        val strMeasure20: String?,
        @SerializedName("strMeasure3")
        val strMeasure3: String?, // 3
        @SerializedName("strMeasure4")
        val strMeasure4: String?, // 1 tbs
        @SerializedName("strMeasure5")
        val strMeasure5: String?, // 1/2
        @SerializedName("strMeasure6")
        val strMeasure6: String?, // To taste
        @SerializedName("strMeasure7")
        val strMeasure7: String?, // To taste
        @SerializedName("strMeasure8")
        val strMeasure8: String?, // Top
        @SerializedName("strMeasure9")
        val strMeasure9: String?,
        @SerializedName("strSource")
        val strSource: String?
        // Add more ingredients as needed...
    )
}