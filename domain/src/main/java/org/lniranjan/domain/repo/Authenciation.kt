package org.lniranjan.domain.repo

import org.lniranjan.domain.entity.User

interface Authenciation {
    fun login(user: User)
    fun logout(user: User)
    fun sighnOff(user: User)
}