package org.lniranjan.domain.repo

import android.provider.ContactsContract
import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.User

interface Authenciation {
    fun login(email: String?, passwrd: String): Flow<Boolean>
    fun logout(user: User):Flow<Boolean>
    fun sighnUp(user: User):Flow<Boolean>
}