package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.User

interface Authenciation {
    fun login(user: User): Flow<Boolean>
    fun logout(user: User):Flow<Boolean>
    fun sighnOff(user: User):Flow<Boolean>
}