package org.lniranjan.chatclone.ui.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.lniranjan.chatclone.modal.Credentials
import org.lniranjan.chatclone.ui.state.AuthState
import org.lniranjan.chatclone.ui.state.UiState
import org.lniranjan.chatclone.ui.state.UserState
import org.lniranjan.chatclone.utils.EntityMapper
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.usecases.auth.LoginUseCase
import org.lniranjan.domain.usecases.auth.SignOutUseCase
import org.lniranjan.domain.usecases.auth.SignUpUseCase
import javax.inject.Inject


class AuthViewModel @Inject constructor(
    private val loginusecase: LoginUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val signUpUseCase: SignUpUseCase,
    private val entityMapper: EntityMapper
) : ViewModel() {
    private val _user = MutableStateFlow(AuthState())
    val user: StateFlow<AuthState> = _user
    private val _userData = MutableStateFlow(UserState())
    val userData: StateFlow<UserState> = _userData


    fun login(credentials: Credentials) {
                  loginusecase.execute(LoginUseCase.Request(credentials.mail, credentials.password))
                      .map {
                           entityMapper.convert(it)
                      }.onEach {
                          when(it)
                          {
                              is UiState.Success-> {
                                  _user.value = AuthState()
                              }
                              is UiState.Error -> {
                                  _user.value = AuthState(error = it.errorMessage)
                              }
                              is UiState.Loading ->  {
                                  _user.value = AuthState(isLoading = true)
                              }
                              else -> {

                              }
                          }
                      }
    }

    fun register(credentials: Credentials) {
            viewModelScope.launch {
                signUpUseCase.execute(SignUpUseCase.Request(User(credentials.mail,credentials.password)))
            }
    }


}