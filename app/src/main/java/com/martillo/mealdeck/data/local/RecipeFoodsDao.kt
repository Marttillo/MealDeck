package com.martillo.mealdeck.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeFoodsDao {

    @Query("SELECT * FROM Recipe_Foods")
    fun getAll(): Flow<List<RecipeFoods>>

    @Insert
    suspend fun insert(data: RecipeFoods)

    @Update
    suspend fun update(data: RecipeFoods)

    @Delete
    suspend fun delete(data: RecipeFoods)
}