package com.martillo.mealdeck.data.local
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanDao {
    @Query("SELECT * FROM `Plan`")
    fun getAll(): Flow<List<Plan>>

    @Insert
    suspend fun insert(data: Plan)

    @Delete
    suspend fun delete(data: Plan)

    @Update
    suspend fun update(data: ShoppingList)

    @Query("DELETE FROM `Plan`")
    suspend fun clear()
}