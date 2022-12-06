package org.lniranjan.domain.usecases

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.Result
import org.lniranjan.domain.entity.UseCaseException

abstract class UseCase<I: UseCase.Request, O: UseCase.Response>(private val configuration: Configuration) {
    suspend fun execute(request: I): Flow<Result<O>> {

        return process(request)
            .map {
                Log.d("UseCase 2 ", "Sucess : ${it}")
                Result.Success(it) as Result<O>
            }
            .flowOn(configuration.dispatcher)
            .catch {
            Log.d("UseCase1 ", "Error: ${it.message}")
                emit(Result.Error(UseCaseException.createFromThrowable(it)))
            }
    }
     abstract suspend fun process(request:I): Flow<O>
    class Configuration(val dispatcher: CoroutineDispatcher)
    interface Request
    interface Response
}
