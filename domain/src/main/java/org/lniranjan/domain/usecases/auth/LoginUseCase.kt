package org.lniranjan.domain.usecases.auth

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.usecases.UseCase

class LoginUseCase(
    configuration: Configuration,
    private val authenciation: Authenciation
) : UseCase<LoginUseCase.Request, LoginUseCase.Response>(configuration)
{

    data class Request(val email : String, val password : String) : UseCase.Request
    data class Response(val credentialMatched : Boolean ) : UseCase.Response

    override fun process(request: Request): Flow<Response> = authenciation.login(
                                                        request.email,
        request.password
    ).map { Response(it) }
}