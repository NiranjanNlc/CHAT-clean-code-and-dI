package org.lniranjan.chatclone.utils

import org.lniranjan.chatclone.ui.state.UiState
import org.lniranjan.domain.entity.Result
import org.lniranjan.domain.entity.Result.Success
import org.lniranjan.domain.usecases.auth.LoginUseCase

class EntityMapper {

    fun convert(response: Result<LoginUseCase.Response>): UiState<Boolean>? {
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

}