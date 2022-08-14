package org.lniranjan.domain.repo

import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User

interface Chatting {

    fun getListOfChats(): List<Chat>
    fun getListOfUser():List<User>
}