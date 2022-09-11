package org.lniranjan.domain.usecases.profile

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.ProfileDetail
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Chatting
import org.lniranjan.domain.repo.Profile
import org.lniranjan.domain.usecases.UseCase
import org.lniranjan.domain.usecases.chat.GetListofChat

class GetProfileDetail(
    configuration: Configuration,
    private val  profile:Profile
) : UseCase<GetProfileDetail.Request, GetProfileDetail.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request
    data class Response(val profile: ProfileDetail) : UseCase.Response
    override suspend fun process(request: Request): Flow<Response> =  profile.getProfile(request.user)
        .map {
            Response(it)
        }
}