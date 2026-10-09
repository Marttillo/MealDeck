package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
table diary{
  id integer [primary key]
  datetime integer [not null]
  recipe_id integer [ref: > recipes.id]
  food_id integer  [ref: > foods.id]
  servings real
  grams real
}
*/
@Entity(tableName = "Diary")
data class Diary(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "datetime") val datetime: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "brand") val brand: String?,
    @ColumnInfo(name = "kcal") val kcal: Double?,
    @ColumnInfo(name = "fat") val fat: Double?,
    @ColumnInfo(name = "sat_fat") val satFat: Double?,
    @ColumnInfo(name = "carbs") val carbs: Double?,
    @ColumnInfo(name = "sugar") val sugar: Double?,
    @ColumnInfo(name = "fiber") val fiber: Double?,
    @ColumnInfo(name = "protein") val protein: Double?,
    @ColumnInfo(name = "servings") val servings: Double,
    @ColumnInfo(name = "grams") val grams: Double,

)