package org.lniranjan.chatclone.ui.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.lniranjan.chatclone.modal.Credentials
import org.lniranjan.chatclone.ui.userstate.AuthState
import org.lniranjan.chatclone.ui.userstate.UserState
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.usecases.auth.LoginUseCase
import org.lniranjan.domain.usecases.auth.SignOutUseCase
import org.lniranjan.domain.usecases.auth.SignUpUseCase
import javax.inject.Inject


class AuthViewModel @Inject constructor(
    private val loginusecase: LoginUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    private val _user = MutableStateFlow(AuthState())
    val user: StateFlow<AuthState> = _user
    private val _userData = MutableStateFlow(UserState())
    val userData: StateFlow<UserState> = _userData


    fun login(credentials: Credentials) {
        viewModelScope.launch {
                  loginusecase.process(LoginUseCase.Request(credentials.mail, credentials.password))
              }
    }

    fun register(credentials: Credentials) {
            viewModelScope.launch {
                signUpUseCase.process(SignUpUseCase.Request(User(credentials.mail,credentials.password)))
            }
    }

    fun loggedCredentials() {

    }

    fun getCredentialsData() {

    }


}