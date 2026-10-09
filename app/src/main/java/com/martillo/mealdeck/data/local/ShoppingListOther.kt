package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
table shopping_list_other {
  id integer [primary key]
  item text
  tick boolean
}
*/
@Entity(tableName = "Shopping_List_Other")
data class ShoppingListOther(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "item") val item: String,
    @ColumnInfo(name = "grams") val grams: Double,
    @ColumnInfo(name = "tick") val tick: Boolean,
)