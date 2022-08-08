package org.lniranjan.chatclone.domain.repo

import org.lniranjan.chatclone.domain.modal.Message

interface Messaging {

    fun editMessage(message: Message):Message
    fun sendMessage(message: Message): Boolean
}