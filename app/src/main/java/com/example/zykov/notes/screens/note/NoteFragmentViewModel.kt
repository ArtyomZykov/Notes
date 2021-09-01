package com.example.zykov.notes.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.zykov.notes.models.AppNote
import com.example.zykov.notes.utilites.REPOSITORY
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun delete(note: AppNote, onSuccess: ()->Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }
}