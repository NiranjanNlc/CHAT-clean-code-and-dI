package org.lniranjan.domain.repo

import org.lniranjan.domain.modal.Message

interface Messaging {

    fun editMessage(message: Message):Message
    fun sendMessage(message: Message): Boolean
}