package com.example.tugasramadhanday2_3

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {


    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }

    // Karena objek ini hanya boleh dibuat saat pertama kali
// diperlukan, bukan saat pengaktifan aplikasi, Anda akan menggunakan delegasi properti Kotlin: by lazy.
}