package com.martillo.mealdeck.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "Ingredients",
    indices = [
        Index(value = ["name"], unique = false, name = "idx_ingredients_name"),
        Index(value = ["code"], unique = false, name = "idx_ingredients_code"),
    ],)
data class Ingredients(
    @PrimaryKey(autoGenerate = false) val id: Long,
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