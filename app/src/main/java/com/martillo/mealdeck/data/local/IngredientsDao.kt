package com.martillo.mealdeck.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientsDao {

    @Query("SELECT * FROM Ingredients LIMIT :limit OFFSET :offset")
    fun getAll(limit:Int=100,offset:Int=0): Flow<List<Ingredients>>

    @Query("SELECT * FROM Ingredients WHERE name LIKE ''||:q||'%' LIMIT 100")
    fun search(q:String): Flow<List<Ingredients>>

}