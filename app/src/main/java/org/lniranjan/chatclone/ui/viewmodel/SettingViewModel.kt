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
import org.lniranjan.chatclone.modal.ProfileDetail
import org.lniranjan.chatclone.utils.EntityMapper
import org.lniranjan.domain.entity.User
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    val getProfileDetail: GetProfileDetail,
    val updateProfileDetail: UpdateProfileDetail,
    val updateProfilePhoto: UpdateProfilePhoto
): ViewModel() {
    val profileDetail = MutableLiveData<ProfileDetail>()
    val _profileDetail: LiveData<ProfileDetail> = profileDetail

    val currenUser = MutableLiveData<User>()
    val currentUserId : LiveData<String> = MutableLiveData<String>("T520rsExXWdb5K4LqcHK21Mdtjo2")

    init {
        getProfileDetail()
      Log.i(" strted view modal ", "started view modal")
     }

    /* Get profile detaile */
    fun getProfileDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getProfileDetail.process(GetProfileDetail.Request(currentUserId.value.toString()))
            val userDetail = EntityMapper.convertToProfileDetail(result.first())
            profileDetail.postValue(userDetail)
            Log.i("SettingViewModel", "getProfileDetail: ${result.first().profile}")
        }
    }
        /* update profile detaile */
        fun updateProfileDetail(profileDetail: ProfileDetail) {
            val profileMap: HashMap<String, String> = HashMap()
            profileMap["profilePhoto"] = profileDetail.profilePhoto.toString()
            profileMap["name"] = profileDetail.name.toString()
            profileMap["bio"] = profileDetail.bio.toString()
            viewModelScope.launch (Dispatchers.IO){
                updateProfileDetail.process(UpdateProfileDetail.Request(profileMap, currentUserId.value.toString()))
                    .onEach {
                        Log.i("SettingViewModel", "updateProfileDetail: ${it.updateStatus}")
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