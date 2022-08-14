package org.lniranjan.domain.entity



sealed class Result<out T : Any?>{
    data class Success<out T : Any?>(val data:T): Result<T>()
    data class Error<out T : Any?>(val exception: UseCaseException): Result<Nothing>()
}
