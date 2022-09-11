package org.lniranjan.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lniranjan.data.source.firebase.Firebasemessaging
import org.lniranjan.domain.entity.Message
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Messaging

class MessagingImpl(private val firebaseMessaging: Firebasemessaging) : Messaging {
    override fun editMessage(message: Message): Flow<Message> {
        firebaseMessaging.updateSenderMessage(message)
        firebaseMessaging.updateReceiverMessage(message)
        return flow { emit(message) }
    }

    override fun sendMessage(sender: User, receiver: User, message: Message): Flow<Boolean> {
        firebaseMessaging.updateSenderMessage(message)
        firebaseMessaging.updateReceiverMessage(message)
        return flow { emit(true) }    }

    override fun getListOfMessage(sender: User, receiver: User): Flow<List<Message>> {
       return  flow {  firebaseMessaging.getMessages(sender.userId,receiver.userId)}
     }


}
/*
* fun getMessages(): Flow<List<Message>> {
        return firebaseMessaging.getMessages()
    }

    fun sendMessage(message: Message) {
        firebaseMessaging.sendMessage(message)
    }

    fun getOnlineUsers(): Flow<List<User>> {
        return firebaseMessaging.getOnlineUsers()
    }

    fun getOfflineUsers(): Flow<List<User>> {
        return firebaseMessaging.getOfflineUsers()
    }

    fun getTypingUsers(): Flow<List<User>> {
        return firebaseMessaging.getTypingUsers()
    }

    fun setOnlineUser(user: User) {
        firebaseMessaging.setOnlineUser(user)
    }

    fun setOfflineUser(user: User) {
        firebaseMessaging.setOfflineUser(user)
    }

    fun setTypingUser(user: User) {
        firebaseMessaging.setTypingUser(user)
    }

    fun removeTypingUser(user: User) {
        firebaseMessaging.removeTypingUser(user)
    }
* */