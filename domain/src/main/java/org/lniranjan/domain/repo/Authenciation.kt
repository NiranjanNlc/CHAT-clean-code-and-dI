package org.lniranjan.domain.repo

import android.provider.ContactsContract
import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.User

interface Authenciation {
    suspend fun login(email: String, passwrd: String): Flow<Boolean>
    fun logout( ):Flow<Boolean>
    fun sighnUp(user: User):Flow<User>
    fun getUser():Flow<User>
}