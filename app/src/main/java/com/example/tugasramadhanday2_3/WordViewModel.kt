package com.example.tugasramadhanday2_3

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository):ViewModel() {
    val allWords: LiveData<List<TableName>> = repository.allWords.asLiveData()
    // live data di gunakan untuk menyimpan daftar ke cache

    fun insert(word: TableName) = viewModelScope.launch {
        repository.insert(word)
    }


}
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}