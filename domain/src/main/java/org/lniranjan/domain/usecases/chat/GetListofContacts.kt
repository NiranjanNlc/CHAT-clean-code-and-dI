package org.lniranjan.domain.usecases.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Chatting
import org.lniranjan.domain.usecases.UseCase
import javax.inject.Inject

class GetListofContacts @Inject constructor(
    configuration: Configuration,
    private val chatting: Chatting
) : UseCase<GetListofContacts.Request, GetListofContacts.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request
    data class Response(val userList: List<User>) : UseCase.Response

    override suspend fun process(request:Request): Flow<Response> = chatting.getListOfUser(request.user.userId!!)
        .map { Response(it) }
}