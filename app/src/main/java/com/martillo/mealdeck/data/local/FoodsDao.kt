package com.martillo.mealdeck.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodsDao {

    @Query("SELECT * FROM Foods LIMIT 100 OFFSET :offset")
    fun getAll(offset:Int=0): Flow<List<Foods>>

    @Query("SELECT * FROM Foods WHERE name LIKE ''||:q||'%' LIMIT 100")
    fun search(q:String): Flow<List<Foods>>

    @Insert
    suspend fun insert(data: Foods)

    @Delete
    suspend fun delete(data: Foods)
}