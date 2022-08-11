package org.lniranjan.domain.repo

import org.lniranjan.domain.modal.Chat
import org.lniranjan.domain.modal.User

interface Chatting {

    fun getListOfChats(): List<Chat>
    fun getListOfUser():List<User>
}