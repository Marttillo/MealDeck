package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Table recipes_foods {
  id integer [primary key]
  recipe_id integer [ref: > recipes.id]
  food_id integer [ref: > foods.id]
  grams real
}

 */

@Entity(tableName = "Recipe_Foods")
data class RecipeFoods(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "recipe_id")  val recipeId: Long=0,
    @ColumnInfo(name = "food_id") val foodId: Long=0,
    @ColumnInfo(name = "grams") val grams: Double,
)