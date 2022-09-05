package org.lniranjan.chatclone.ui.state

import org.lniranjan.chatclone.modal.Credentials

data class AuthState(
    val data: Credentials? = null,
    val error: String = "",
    val isLoading: Boolean = false
)