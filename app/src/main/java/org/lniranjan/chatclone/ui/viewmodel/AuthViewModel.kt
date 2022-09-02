package org.lniranjan.chatclone.ui.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.lniranjan.domain.entity.User
 


class AuthViewModel  : ViewModel() {

 
     public val user: LiveData<User> = MutableLiveData<User>()
    fun login(user: User) {

    }

    fun register(user: User) {
 

    }

    fun loggedUser() {

    }

    fun getUserData() {

    }


}