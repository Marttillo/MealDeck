package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Table recipes {
  id integer [primary key]
  name text
  instructions text
  desc text
  servings real [not null, default: 1]
}*/
@Entity(tableName = "Recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "instructions") val instructions: String,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "servings") val servings: Double,
)