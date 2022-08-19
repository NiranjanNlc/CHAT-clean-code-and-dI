package org.lniranjan.domain.usecases.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.Message
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Chatting
import org.lniranjan.domain.repo.Messaging
import org.lniranjan.domain.usecases.UseCase

class GetListofMessage (configuration: UseCase.Configuration,
private val messaging: Messaging):UseCase<GetListofMessage.Request,GetListofMessage.Response>(configuration){
    data class Request(val user1: User, val user2: User) : UseCase.Request
    data class Response(val messagelIst : List<Message>) : UseCase.Response
    override fun process(request: Request): Flow<Response> = messaging.
    getListOfMessage(request.user1,request.user2).
            map { Response(it) }
}