package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.ViewModel
import org.lniranjan.domain.usecases.profile.GetProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfilePhoto
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.lniranjan.domain.entity.ProfileDetail
import org.lniranjan.domain.entity.User
import javax.inject.Inject

class BioViewModel @Inject constructor(
    val getProfileDetail: GetProfileDetail,
    val updateProfileDetail: UpdateProfileDetail,
    val updateProfilePhoto: UpdateProfilePhoto
): ViewModel()
{

    /* Get profile detaile */
    fun getProfileDetail(user: User)
    {
        viewModelScope.launch {
            getProfileDetail.process(GetProfileDetail.Request(user))
        }
    }
    /* update profile detaile */
    fun updateProfileDetail(profileDetail: ProfileDetail)
    {
        viewModelScope.launch {
            updateProfileDetail.process(UpdateProfileDetail.Request(profileDetail))
        }
    }
    /* Get profile detaile */
    fun updateProfilePhoto(profileDetail: ProfileDetail)
    {
        viewModelScope.launch {
            updateProfilePhoto.process(UpdateProfilePhoto.Request(profileDetail))
        }
    }
}