package org.lniranjan.data.source.firebase

import android.provider.SyncStateContract.Helpers.get
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.Message
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Messaging
import javax.inject.Inject

class Firebasemessaging @Inject constructor(
     private val rootRef : DatabaseReference
) {

    fun updateSenderMessage(message: Message) {
        message.senderId?.let { message.receiverId?.let { it1 ->
            rootRef.child("messages").child(it).child(
                it1
            ).push().
            setValue(message)
        } }
    }
   fun updateReceiverMessage(message: Message)
   {
       message.receiverId?.let { message.senderId?.let { it1 ->
       rootRef.child("messages").child(it).child(
           it1
       ).push().setValue(message)
   }
   }
   }
    suspend fun getMessages(senderId: String, receiverId: String): Flow<Message> {
        return (rootRef.child("messages").child(senderId).child(receiverId)).
                get()
            .await().children.map {  it.getValue(Message::class.java) }
                as Flow<Message>
    }
    suspend fun getSender(senderId: String): Flow<User> {
        return (rootRef.child("users").child(senderId)).get().
        await().
        getValue(User::class.java) as Flow<User>

    }
    suspend fun getReceiver(receiverId: String): Flow<User> {
        return (rootRef.child("users").child(receiverId)).get().
        await().getValue(User::class.java) as Flow<User>
    }
   }
}