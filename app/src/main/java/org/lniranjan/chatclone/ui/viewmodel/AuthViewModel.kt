package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject



class AuthViewModel  : ViewModel() {


    fun login(email: String, password: String) {

    }

    fun register(email: String, password: String) {

    }

    fun loggedUser() {

    }

    fun getUserData() {

    }


}