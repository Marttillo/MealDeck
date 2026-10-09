package com.martillo.mealdeck

import android.app.Application
import androidx.room.Room
import com.martillo.mealdeck.data.SearchRepository
import com.martillo.mealdeck.data.local.AppDatabase
import com.martillo.mealdeck.data.local.CatalogDatabase

class App : Application(){
    lateinit var catalog: CatalogDatabase
        private set
    lateinit var db: AppDatabase
        private set
    lateinit var searchRepository: SearchRepository
        private set
    override fun onCreate() {
        super.onCreate()
        catalog = Room.databaseBuilder(
            this,
            CatalogDatabase::class.java,
            "catalog.db"
        )
            .createFromAsset("catalog.db")
            .fallbackToDestructiveMigration(dropAllTables = true)
            .build()

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "user.db"
        ).build()

        searchRepository = SearchRepository(
            IngredientDao = catalog.IngredientsDao(),
            FoodsDao = db.FoodsDao(),
            RecipeDao = db.RecipeDao(),
        )
    }




}