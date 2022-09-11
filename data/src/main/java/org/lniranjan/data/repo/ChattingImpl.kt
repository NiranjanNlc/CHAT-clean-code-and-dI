package org.lniranjan.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lniranjan.data.source.firebase.FireBaseChats
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Chatting

class ChattingImpl(private val fireBaseChats: FireBaseChats) : Chatting {
    override fun getListOfChats( uid : String): Flow<List<Chat>> {
        return flow {
            fireBaseChats.getListOfChats( uid )
        }
    }

    override fun getListOfUser(uid: String): Flow<List<User>> {
        return flow {
            fireBaseChats.getListOfUser(uid)
        }
            }
}
/*

fun     getChatList(): Flow<List<Chat>> = chattingRepo.getChatList()
fun     getChat(chatId: String): Flow<Chat> = chattingRepo.getChat(chatId)
fun     getChatMessages(chatId: String): Flow<List<Chat.Message>> = chattingRepo.getChatMessages(chatId)
fun     getChatUsers(chatId: String): Flow<List<User>> = chattingRepo.getChatUsers(chatId)
suspend fun addChat(chat: Chat) = chattingRepo.addChat(chat)
suspend fun addMessage(chatId: String, message: Chat.Message) = chattingRepo.addMessage(chatId, message)
suspend fun addUser(chatId: String, user: User) = chattingRepo.addUser(chatId, user)
suspend fun removeUser(chatId: String, user: User) = chattingRepo.removeUser(chatId, user)
* */
/*
 */
