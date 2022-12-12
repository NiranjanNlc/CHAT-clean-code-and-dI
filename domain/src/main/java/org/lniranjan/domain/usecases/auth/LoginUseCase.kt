package org.lniranjan.domain.usecases.auth

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.usecases.UseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    configuration: Configuration,
    private val authenciation: Authenciation
) : UseCase<LoginUseCase.Request, LoginUseCase.Response>(configuration)
{

    data class Request(val email : String, val password : String) : UseCase.Request
    data class Response(val result: org.lniranjan.domain.entity.Result<Any>) : UseCase.Response

    override suspend fun process(request: LoginUseCase.Request): Flow<Response> {
        val para = authenciation.login(request.email,request.password)
            .map {
                Response(it)
            }
        Log.i(" Para ", "process: ${para.first().result}")
        return para
    }

}