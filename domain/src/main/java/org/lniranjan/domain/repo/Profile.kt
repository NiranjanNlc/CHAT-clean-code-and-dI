package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.entity.UserDetail

interface Profile {
    fun updateProfile(profileDetail: HashMap<String, String>, userid: String):Flow<Boolean>
    fun getProfile(user: String): Flow<UserDetail>
    fun updateProfilePhoto (profileDetail: String, userId: String):Flow<Boolean>
}