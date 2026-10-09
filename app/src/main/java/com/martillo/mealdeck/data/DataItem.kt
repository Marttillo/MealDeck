package com.martillo.mealdeck.data

import androidx.room.Dao


data class DataItem(
    var source: String,
    val name: String,
    var id: Long?,
    var code:String?,
    val brand: String?,
    val kcal: Double?,
    val fat: Double?,
    val satFat: Double?,
    val carbs: Double?,
    val sugar: Double?,
    val fiber: Double?,
    val protein: Double?,
    val servings: Double?,
    val grams: Double?,
)

@Dao
interface SearchDao{

}