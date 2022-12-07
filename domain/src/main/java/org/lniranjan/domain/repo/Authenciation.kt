package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.User

interface Authenciation {
    suspend fun login(email: String, passwrd: String): Flow<Boolean>
    fun logout( ):Flow<Boolean>
    fun getUser():Flow<User>
    suspend fun signUp(user: User): Flow<User>
}