package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
/*
table shopping_list {
  id integer [primary key]
  food_id integer [ref: > foods.id]
  tick boolean
  grams real
  indexes {
    food_id [unique]
  }
}
*/

@Entity(tableName = "Shopping_List")
data class ShoppingList(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "food_id") val foodId: Long,
    @ColumnInfo(name = "grams") val grams: Double,
    @ColumnInfo(name = "tick") val tick: Boolean,
)