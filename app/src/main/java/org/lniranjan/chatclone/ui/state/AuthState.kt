package org.lniranjan.chatclone.ui.state

import org.lniranjan.domain.entity.User

data class AuthState(
    val data: User? = null,
    val error: String = "",
    val isLoading: Boolean = false
)