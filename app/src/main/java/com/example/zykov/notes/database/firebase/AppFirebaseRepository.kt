package com.example.zykov.notes.database.firebase

import android.os.Message
import androidx.lifecycle.LiveData
import com.example.zykov.notes.database.DatabaseRepository
import com.example.zykov.notes.models.AppNote
import com.example.zykov.notes.utilites.EMAIL
import com.example.zykov.notes.utilites.PASSWORD
import com.google.firebase.auth.FirebaseAuth

class AppFirebaseRepository : DatabaseRepository {
    private val mAuth = FirebaseAuth.getInstance()


    override val allNotes: LiveData<List<AppNote>>
        get() = TODO("Not yet implemented")

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }

    override fun signOut() {
        mAuth.signOut()
    }
}