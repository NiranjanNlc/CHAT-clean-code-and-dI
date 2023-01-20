package org.lniranjan.data.source.firebase

import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Chatting
import javax.inject.Inject

class FireBaseChats  @Inject constructor(
    private val rootRef : DatabaseReference
){
     suspend fun getListOfChats(uid: String): List<Chat>? {
         try {
             return rootRef.child("chats/$uid")
                 .get()
                 .await()
                 .children
                 .map { it.getValue(Chat::class.java)!! }
                 .toList()
         }
         catch (e : Exception)
         {
             e.printStackTrace()
             return   null
         }
    }

    suspend fun getListOfUser(uid: String): List<User> {
        return try {
            rootRef.child("users")
                .get()
                .await()
                .children
                .map { it.getValue(User::class.java)!! }
                .filter {
                    it.userId != uid
                }.toList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}