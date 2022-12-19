package org.lniranjan.chatclone.ui.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.lniranjan.domain.usecases.profile.GetProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfilePhoto
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
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
    val currentUserId : LiveData<String> = MutableLiveData<String>("T520rsExXWdb5K4LqcHK21Mdtjo2")

    init {
      Log.i(" strted view modal ", "started view modal")
     }

    /* Get profile detaile */
    fun getProfileDetail(userId: String) {

//        viewModelScope.launch {
//            val result = getProfileDetail.process(GetProfileDetail.Request(userId))
//            Log.i("SettingViewModel", "getProfileDetail: ${result.first().profile}")
//        }
    }
        /* update profile detaile */
        fun updateProfileDetail(profileDetail: UserDetail) {
            viewModelScope.launch {
                updateProfileDetail.process(UpdateProfileDetail.Request(currenUser.value!!))
                    .onEach {

                    }.launchIn(viewModelScope)
            }
        }
    /* update profile photo */

    fun uploadProfileImage(selectedImageUri: Uri) {

        Log.i(" uploadProfileImage ","Niranjan Lamichhane ")
            viewModelScope.launch(Dispatchers.IO) {
                Log.i(" uploadProfileImage ", "${selectedImageUri.path.toString()} uploadProfileImage: $selectedImageUri")
              try {
                  val result = updateProfilePhoto.process(UpdateProfilePhoto.Request(
                      selectedImageUri.toString(),
                      currentUserId.value!!
                  ))
                  Log.i(" uploadProfileImage ", "submit: ${result.first()}")
              }
                catch (e: Exception) {
                    Log.i(" uploadProfileImage ", "uploadProfileImage: ${e.message}")
                }

        }
    }
}