package com.example.zykov.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.zykov.notes.utilites.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes // LiveData
}