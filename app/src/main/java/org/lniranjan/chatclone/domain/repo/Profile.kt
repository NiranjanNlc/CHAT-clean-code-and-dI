package org.lniranjan.chatclone.domain.repo

interface Profile {
    fun updateProfile(): Profile
    fun getProfile(): Profile
}