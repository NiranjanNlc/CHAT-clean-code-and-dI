package org.lniranjan.chatclone.domain.repo

import org.lniranjan.chatclone.domain.modal.User

interface Authenciation {
    fun login(user: User)
    fun logout(user: User)
    fun sighnOff(user: User)
}