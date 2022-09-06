package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User

interface Chatting {
    fun getListOfChats(): Flow<List<Chat>>
    fun getListOfUser():Flow<List<User>>
}