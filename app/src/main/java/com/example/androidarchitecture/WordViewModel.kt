package com.example.androidarchitecture

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application){
    // viewmodel maintain the reference of the repository to get data
    private val wordRepository: WordRepository

    // LiveData gives us updated word when they changes
    val allWord: LiveData<List<Word>>

    init {
        // Get reference to WordDao from WordRoomDatabase to construct
        // the correct wordRepository
        val wordDao = WordRoomDatabase.getDatabase(application,viewModelScope).WordDao()
        wordRepository = WordRepository(wordDao)
        allWord = wordRepository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch {
        wordRepository.insert(word)
    }

}