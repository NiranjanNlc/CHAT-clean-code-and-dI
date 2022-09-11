package org.lniranjan.domain.usecases.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Chatting
import org.lniranjan.domain.usecases.UseCase

class GetListofChat (
    configuration: Configuration,
    private val chatting: Chatting
) : UseCase<GetListofChat.Request, GetListofChat.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request
    data class Response(val chatList: List<Chat>) : UseCase.Response
    override suspend fun process(request: Request): Flow<Response> = chatting.getListOfChats(request.user.userId)
        .map { Response(it) }
}