package com.martillo.mealdeck.data.local
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {
    @Query("SELECT * FROM Diary")
    fun getAll(): Flow<List<Diary>>

    @Insert
    suspend fun insert(data: Diary)

    @Delete
    suspend fun delete(data: Diary)
}