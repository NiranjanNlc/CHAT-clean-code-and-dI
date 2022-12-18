package org.lniranjan.chatclone.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.lniranjan.domain.usecases.profile.GetProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfilePhoto
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.lniranjan.chatclone.modal.UserDetail
import org.lniranjan.domain.entity.User
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    val getProfileDetail: GetProfileDetail,
    val updateProfileDetail: UpdateProfileDetail,
    val updateProfilePhoto: UpdateProfilePhoto
): ViewModel() {
    val profileDetail = MutableLiveData<UserDetail>()
    val _profileDetail: LiveData<UserDetail> = profileDetail

    val currenUser = MutableLiveData<User>()

    init {
      Log.i(" strted view modal ", "started view modal")
     }

    /* Get profile detaile */
    fun getProfileDetail(user: User) {
        viewModelScope.launch {
            getProfileDetail.process(GetProfileDetail.Request(user))
                .onEach {

                }.launchIn(viewModelScope)
    }

    /* update profile detaile */
    fun updateProfileDetail(profileDetail: UserDetail) {
        viewModelScope.launch {
            updateProfileDetail.process(UpdateProfileDetail.Request(currenUser.value!!))
                .onEach {

                }.launchIn(viewModelScope)
        }
    }

    /* Get profile detaile */
    fun updateProfilePhoto(profileDetail: UserDetail) {
        viewModelScope.launch {
            updateProfilePhoto.process(UpdateProfilePhoto.Request(currenUser.value!!))
                .onEach {

                }.launchIn(viewModelScope)
        }
    }
}

}