package com.example.tugasramadhanday2_3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {
//    @Query("SELECT*FROM `TableName` ORDER BY kata ASC")
//    fun getAlphabetizedWords(): List<UserDictionary.Words>

    @Query("SELECT*FROM `TableName` ORDER BY kata ASC")
    fun getAlphabetizedWords(): Flow<List<TableName>>

    //flow di gunakan untuk mengamati data secara satu per satu dan data paling terbaru
    //ROOM itu pengganti SQLLite open helper
    //room menggunakan dao untuk mengeluarkan query ke databasenya

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (word: TableName)

    @Query("DELETE FROM `TableName`")
    suspend fun deleteAll()
}