package org.lniranjan.domain.usecases.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.Message
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Messaging
import org.lniranjan.domain.usecases.UseCase

class SendMessage( configuration: UseCase.Configuration,
private val messaging: Messaging):UseCase<SendMessage.Request,SendMessage.Response>(configuration) {
    data class Request(val sender: User, val reciver: User, val msg1: Message) : UseCase.Request
    data class Response(val sendStatus: Boolean) : UseCase.Response
    override suspend fun process(request: Request): Flow<Response> =
        messaging.sendMessage(request.sender, request.reciver, request.msg1)
            .map { Response(it) }
}