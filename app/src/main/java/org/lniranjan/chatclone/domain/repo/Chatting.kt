package org.lniranjan.chatclone.domain.repo

import org.lniranjan.chatclone.domain.modal.Chat
import org.lniranjan.chatclone.domain.modal.User

interface Chatting {

    fun getListOfChats(): List<Chat>
    fun getListOfUser():List<User>
}