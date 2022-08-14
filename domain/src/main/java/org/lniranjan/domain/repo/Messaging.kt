package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.Message

interface Messaging {

    fun editMessage(message: Message):Flow<Message>
    fun sendMessage(message: Message): Flow<Boolean>
}