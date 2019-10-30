package com.example.androidarchitecture

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao{
    @Query("select * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query ("delete from word_table")
    suspend fun  deleteAllWord();
}