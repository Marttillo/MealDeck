package com.martillo.mealdeck.ui.home

data class HomeState(
    val kcal: Double,
    val targetKcal: Double,
    val carbs: Double,
    val targetCarbs: Double,
    val protein: Double,
    val targetProtein: Double,
    val fat: Double,
    val targetFat: Double,
    val sugar: Double,
    val targetSugar: Double,
)