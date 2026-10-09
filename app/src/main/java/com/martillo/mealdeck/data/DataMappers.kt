package com.martillo.mealdeck.data

import com.martillo.mealdeck.data.local.Foods
import com.martillo.mealdeck.data.local.Ingredients
import com.martillo.mealdeck.data.local.Recipe

fun Foods.toDataItem(): DataItem=
    DataItem(
        source = "f",
        name = name,
        id = id,
        code = code,
        brand = brand,
        kcal = kcal,
        fat = fat,
        satFat = satFat,
        carbs = carbs,
        sugar = sugar,
        fiber = fiber,
        protein = protein,
        servings = null,
        grams = null
    )

fun Ingredients.toDataItem(): DataItem=
    DataItem(
        source = "i",
        name = name,
        id = null,
        code = code,
        brand = brand,
        kcal = kcal,
        fat = fat,
        satFat = satFat,
        carbs = carbs,
        sugar = sugar,
        fiber = fiber,
        protein = protein,
        servings = null,
        grams = null
    )
fun Recipe.toDataItem(): DataItem=
    DataItem(
        source = "r",
        name = name,
        id = id,
        code = null,
        brand = null,
        kcal = null,
        fat = null,
        satFat = null,
        carbs = null,
        sugar = null,
        fiber = null,
        protein = null,
        servings = null,
        grams = null
    )
