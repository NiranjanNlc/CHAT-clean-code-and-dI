package org.lniranjan.domain.usecases.auth

import android.util.Log
import kotlinx.coroutines.flow.*
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.usecases.UseCase
import org.lniranjan.domain.entity.Result as Result1

class SignUpUseCase (
    configuration: Configuration,
    private val authenciation: Authenciation
) : UseCase<SignUpUseCase.Request, SignUpUseCase.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request 
    data class Response(val result: org.lniranjan.domain.entity.Result<Any>) : UseCase.Response

    override suspend fun process(request: Request): Flow<Response> =authenciation.signUp(request.user)
        .map {
            Log.i("SignUpUseCase 345 ", "process: $it")
            Response(it)
        }


}