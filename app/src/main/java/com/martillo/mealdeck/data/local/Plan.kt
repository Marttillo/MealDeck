package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
table plan {
  id integer [primary key]
  recipe_id integer [ref: > recipes.id]
  food_id integer [ref: > foods.id]
  servings real
  grams real
}
*/
@Entity(tableName = "Plan")
data class Plan(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "recipe_id") val recipeId: Long,
    @ColumnInfo(name = "food_id") val foodId: Long,
    @ColumnInfo(name = "servings") val servings: Double,
    @ColumnInfo(name = "grams") val grams: Double,
)