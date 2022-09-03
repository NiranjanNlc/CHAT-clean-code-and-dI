package org.lniranjan.domain.usecases.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Chatting
import org.lniranjan.domain.usecases.UseCase

class GetListofUser(
    configuration: Configuration,
    private val chatting: Chatting
) : UseCase<GetListofUser.Request, GetListofUser.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request
    data class Response(val userList: List<User>) : UseCase.Response

    override fun process(request:Request): Flow<Response> = chatting.getListOfUser()
        .map { Response(it) }
}