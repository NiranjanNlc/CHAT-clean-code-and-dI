package org.lniranjan.data.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.ProfileDetail
import org.lniranjan.domain.entity.User

interface Profile {
    fun updateProfile(profileDetail: ProfileDetail):Flow<Boolean>
    fun getProfile(user: User):Flow<ProfileDetail>
}