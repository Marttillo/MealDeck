package com.martillo.mealdeck.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM Recipe LIMIT 100 OFFSET :offset")
    fun getAll(offset:Int=0): Flow<List<Recipe>>

    @Query("SELECT * FROM Recipe WHERE name LIKE ''||:q||'%' LIMIT 100")
    fun search(q:String): Flow<List<Recipe>>

    @Update
    suspend fun update(data: ShoppingList)

    @Insert
    suspend fun insert(data: Recipe)

    @Delete
    suspend fun delete(data: Recipe)
}
