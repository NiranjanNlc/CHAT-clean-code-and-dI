package org.lniranjan.chatclone.ui.state

import org.lniranjan.domain.entity.User

sealed class UiState<out T : Any> {
    object Loading : UiState<Nothing>()
    data class Error(val errorMessage: String) : UiState<Nothing>()
    data class Success<T : Any>(val data: T) : UiState<T>()
}