package com.martillo.mealdeck.data.local


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListOtherDao {
    @Query("SELECT * FROM `Shopping_List_Other`")
    fun getAll(): Flow<List<ShoppingListOther>>

    @Insert
    suspend fun insert(data: ShoppingListOther)

    @Delete
    suspend fun delete(data: ShoppingListOther)

    @Update
    suspend fun update(data: ShoppingListOther)

    @Query("DELETE FROM Shopping_List_Other")
    suspend fun clear()
}