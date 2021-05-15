package com.androdeveloper.mysocialmedia.daos

import com.androdeveloper.mysocialmedia.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class UserDao {
    private val database = FirebaseFirestore.getInstance()
    private val usersCollection = database.collection("users")
    fun addUser(user: User){
        user.let {
            GlobalScope.launch(Dispatchers.IO) {
                usersCollection.document(user.uid).set(it)
            }
        }
    }
    fun getUserId(uId:String):Task<DocumentSnapshot>{
        return usersCollection.document(uId).get()
    }
}