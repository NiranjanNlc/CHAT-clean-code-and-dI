package org.lniranjan.domain.usecases.auth

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.UserDetail
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.usecases.UseCase

class CurrentUserUsecase(configuration: Configuration,
    private val authenciation: Authenciation
) : UseCase<CurrentUserUsecase.Request, CurrentUserUsecase.Response>(configuration) {

    data class Request(val user: String) : UseCase.Request
    data class Response(val profile: String?) : UseCase.Response

    override suspend fun process(request: Request): Flow<Response> = authenciation.getUser()
        .map {
            Response(it.userId)
        }
}