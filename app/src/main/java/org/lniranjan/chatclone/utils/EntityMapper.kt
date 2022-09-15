package org.lniranjan.chatclone.utils

import org.lniranjan.chatclone.ui.state.UiState
import org.lniranjan.domain.entity.Result
import org.lniranjan.domain.entity.Result.Success
import org.lniranjan.domain.usecases.auth.LoginUseCase
import org.lniranjan.domain.usecases.auth.SignUpUseCase

object EntityMapper {

    fun convert(response: Result<LoginUseCase.Response>): UiState<Any>? {
        return when (response)
        {
            is Success -> {
                UiState.Success(response.data.credentialMatched)
            }
            is Result.Error -> {
                UiState.Error(response.exception.localizedMessage.orEmpty())
            }
        }
    }
    fun convertToAuthState(response: Result<SignUpUseCase.Response>): UiState<Any>? {
        return when (response)
        {
            is Success -> {
                UiState.Success(response.data.user!!)
            }
            is Result.Error -> {
                UiState.Error(response.exception.localizedMessage.orEmpty())
            }
        }
    }

}