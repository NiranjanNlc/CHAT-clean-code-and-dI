package org.lniranjan.chatclone.utils

import android.util.Log
import org.lniranjan.chatclone.ui.state.UiState
import org.lniranjan.domain.entity.Result
import org.lniranjan.domain.entity.Result.Success
import org.lniranjan.domain.entity.Result.Error
import org.lniranjan.domain.usecases.auth.LoginUseCase
import org.lniranjan.domain.usecases.auth.SignUpUseCase

object EntityMapper {

    fun convert(response: LoginUseCase.Response): UiState<Any>? {
        return UiState.Loading as UiState<Any>
    }

    fun convertToAuthState(response: SignUpUseCase.Response): UiState<Any>? {
        return when (response.result) {
            is Success -> {
                UiState.Success((response.result as Success<Any>).data!!)
            }
            is Error -> {
                UiState.Error((response.result as Result.Error).exception.localizedMessage.orEmpty())
            } else -> {
                UiState.Loading
            }
        }
    }
}
