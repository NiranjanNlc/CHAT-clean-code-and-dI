package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User

interface Chatting {
    fun getListOfChats(uid:String): Flow<List<Chat>>
    fun getListOfUser(uid: String):Flow<List<User>>
}