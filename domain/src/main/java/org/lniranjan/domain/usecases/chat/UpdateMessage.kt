package org.lniranjan.domain.usecases.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.Message
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Messaging
import org.lniranjan.domain.usecases.UseCase

class UpdateMessage(configuration: UseCase.Configuration,
                    private val messaging: Messaging
): UseCase<UpdateMessage.Request, UpdateMessage.Response>(configuration) {
    data class Request(val msg1: Message) : UseCase.Request
    data class Response(val updatedMsg: Message) : UseCase.Response
    override fun process(request: Request): Flow<Response>{
       return messaging.editMessage( request.msg1)
            .map { Response(it) }
    }
}