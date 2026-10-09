package com.martillo.mealdeck.data.local
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM Shopping_List")
    fun getAll(): Flow<List<ShoppingList>>

    @Insert
    suspend fun insert(data: ShoppingList)

    @Delete
    suspend fun delete(data: ShoppingList)

    @Update
    suspend fun update(data: ShoppingList)

    @Query("DELETE FROM `Plan`")
    suspend fun clear()
}