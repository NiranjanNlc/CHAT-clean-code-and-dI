package org.lniranjan.domain.usecases.auth

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.usecases.UseCase
import javax.inject.Inject

class SignUpUseCase (
    configuration: Configuration,
    private val authenciation: Authenciation
) : UseCase<SignUpUseCase.Request, SignUpUseCase.Response>(configuration) {
    data class Request(val user: User) : UseCase.Request
    data class Response(val user: User?) : UseCase.Response 
    override suspend fun process(request: Request): Flow<Response> {
        var result = authenciation.sighnUp(request.user)
            .map {
                Response(it)
            }
            Log.d("TAG", "process: ${result.first { true }}")
        Log.i(" regisdter", " $request submit: result ${result.toString()}")
        return result
    }

}