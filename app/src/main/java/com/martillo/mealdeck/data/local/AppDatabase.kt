package com.martillo.mealdeck.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Diary::class,
        Foods::class,
        Plan::class,
        Recipe::class,
        RecipeFoods::class,
        ShoppingList::class,
        ShoppingListOther::class,
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun DiaryDao(): DiaryDao
    abstract fun FoodsDao(): FoodsDao

    abstract fun PlanDao(): PlanDao
    abstract fun RecipeDao(): RecipeDao
    abstract fun RecipeFoodsDao(): RecipeFoodsDao
    abstract fun ShoppingListDao(): ShoppingListDao
    abstract fun ShoppingListOtherDao(): ShoppingListOtherDao
}