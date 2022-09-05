package org.lniranjan.chatclone.ui.state

import org.lniranjan.domain.entity.User

data class UserState(
    val data: User? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
