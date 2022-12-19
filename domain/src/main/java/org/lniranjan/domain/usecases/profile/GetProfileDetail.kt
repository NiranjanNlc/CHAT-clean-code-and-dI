package org.lniranjan.domain.usecases.profile

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Profile
import org.lniranjan.domain.usecases.UseCase
import javax.inject.Inject

class GetProfileDetail @Inject constructor (
    configuration: Configuration,
    private val  profile:Profile
) : UseCase<GetProfileDetail.Request, GetProfileDetail.Response>(configuration) {
    data class Request(val user: String) : UseCase.Request
    data class Response(val profile: User) : UseCase.Response
    override suspend fun process(request: Request): Flow<Response> =  profile.getProfile(request.user)
        .map {
            Response(it)
        }
}