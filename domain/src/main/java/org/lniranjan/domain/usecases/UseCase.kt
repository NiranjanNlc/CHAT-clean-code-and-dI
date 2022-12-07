package org.lniranjan.domain.usecases

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.UseCaseException
import org.lniranjan.domain.entity.Result as Result1
abstract class UseCase<I: UseCase.Request, O : UseCase.Response>(private val configuration: Configuration) {
    suspend fun execute(request: I): Flow<O> {
        return process(request)
            .map {
                Result1.Success(it) as Result1<O>
            }
            .flowOn(configuration.dispatcher)
            .catch {
                Log.e("UseCase", "Error in UseCase", it)
                emit(Result1.Error(UseCaseException.createFromThrowable(it)))
            }
    }
    abstract suspend fun process(request:I): Flow<O>
    class Configuration(val dispatcher: CoroutineDispatcher)
    interface Request
    interface Response
}
