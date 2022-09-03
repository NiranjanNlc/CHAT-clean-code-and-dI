package org.lniranjan.domain.usecases.auth

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.usecases.UseCase

class SignUpUseCase  (
    configuration: Configuration,
    private val authenciation: Authenciation
) : UseCase<SignUpUseCase.Request, SignUpUseCase.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request
    data class Response(val credentialMatched: Boolean) : UseCase.Response

    override fun process(request: Request): Flow<Response> = authenciation.sighnUp(request.user)
        .map {
            Response(it)
        }

}