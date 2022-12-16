package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.User

interface Profile {
    fun updateProfile(profileDetail: User):Flow<Boolean>
    fun getProfile(user: User):Flow<User>
}