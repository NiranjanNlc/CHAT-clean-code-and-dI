package org.lniranjan.domain.entity

sealed class UseCaseException(cause: Throwable): Throwable(cause )
{
    class UnknownException(cause: Throwable): UseCaseException(cause)
    class ChatException(cause: Throwable): UseCaseException(cause)
    class MessageException(cause: Throwable): UseCaseException(cause)
    class UserException(cause: Throwable): UseCaseException(cause)
    class ProfileException(cause: Throwable): UseCaseException(cause)


    companion object {

        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}