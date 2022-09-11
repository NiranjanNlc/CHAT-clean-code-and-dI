package org.lniranjan.data.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.Message
import org.lniranjan.domain.entity.User

interface Messaging {

    fun editMessage( message: Message):Flow<Message>
    fun sendMessage(sender: User,receiver: User,message: Message): Flow<Boolean>
    fun getListOfMessage(sender: User,receiver: User): Flow<List<Message>>
}