package com.martillo.mealdeck.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Ingredients::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class CatalogDatabase  : RoomDatabase(){
    abstract fun IngredientsDao(): IngredientsDao
}