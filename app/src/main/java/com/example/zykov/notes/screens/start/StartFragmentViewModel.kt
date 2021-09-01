package com.example.zykov.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.zykov.notes.database.firebase.AppFirebaseRepository
import com.example.zykov.notes.database.room.AppRoomDatabase
import com.example.zykov.notes.database.room.AppRoomRepository
import com.example.zykov.notes.utilites.REPOSITORY
import com.example.zykov.notes.utilites.TYPE_FIREBASE
import com.example.zykov.notes.utilites.TYPE_ROOM
import com.example.zykov.notes.utilites.showToast

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()}, { showToast(it)})
            }
        }
    }
}