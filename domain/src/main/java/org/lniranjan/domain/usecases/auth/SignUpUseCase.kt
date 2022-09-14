package org.lniranjan.domain.usecases.auth

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.usecases.UseCase
import javax.inject.Inject

class SignUpUseCase @Inject constructor  (
    configuration: Configuration,
    private val authenciation: Authenciation
) : UseCase<SignUpUseCase.Request, SignUpUseCase.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request
    data class Response(val user: User?) : UseCase.Response

    override suspend fun process(request: Request): Flow<Response> =
        authenciation.sighnUp(request.user)
            .map {
                Response(it)
            }


}