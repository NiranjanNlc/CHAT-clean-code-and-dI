package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.lniranjan.chatclone.modal.ProfileDetail
import org.lniranjan.domain.usecases.chat.GetListofContacts
import javax.inject.Inject

class ContactViewModel @Inject constructor(
    private val getListofContacts: GetListofContacts
) : ViewModel() {
    val contactList = MutableLiveData<List<ProfileDetail>>()


    fun getListOfContacts() {
        viewModelScope.launch {
            getListofContacts.process(GetListofContacts.Request(""))
                .map {
                    it.userList.map { user ->
                        ProfileDetail(
                            user.profilePic,
                            user.userName,
                            user.userId
                        )
                    }
                }.first().let {
                    contactList.postValue(it)
                }
        }
    }
}