package org.lniranjan.domain.repo

import kotlinx.coroutines.flow.Flow

interface Profile {
    fun updateProfile(): Flow<Profile>
    fun getProfile():Flow<Profile>
}