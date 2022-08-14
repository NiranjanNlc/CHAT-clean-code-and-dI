package org.lniranjan.domain.repo

import org.lniranjan.domain.entity.Message

interface Messaging {

    fun editMessage(message: Message):Message
    fun sendMessage(message: Message): Boolean
}