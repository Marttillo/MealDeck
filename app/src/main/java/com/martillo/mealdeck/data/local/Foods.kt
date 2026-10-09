package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Table user_ingredients {
  id integer [primary key]
  code text
  name text
  brand text
  kcal real
  fat real
  sat_fat real
  carbs real
  sugars real
  fiber real
  protein real
}
*/
@Entity(tableName = "Foods")
data class Foods(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "brand") val brand: String?,
    @ColumnInfo(name = "kcal") val kcal: Double?,
    @ColumnInfo(name = "fat") val fat: Double?,
    @ColumnInfo(name = "sat_fat") val satFat: Double?,
    @ColumnInfo(name = "carbs") val carbs: Double?,
    @ColumnInfo(name = "sugar") val sugar: Double?,
    @ColumnInfo(name = "fiber") val fiber: Double?,
    @ColumnInfo(name = "protein") val protein: Double?
)