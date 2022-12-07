package org.lniranjan.chatclone.ui.viewmodel



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.lniranjan.chatclone.modal.Credentials
import org.lniranjan.chatclone.ui.state.AuthState
import org.lniranjan.chatclone.ui.state.UiState
import org.lniranjan.chatclone.utils.EntityMapper
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.usecases.auth.LoginUseCase
import org.lniranjan.domain.usecases.auth.SignOutUseCase
import org.lniranjan.domain.usecases.auth.SignUpUseCase
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginusecase: LoginUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    val _user  = MutableLiveData<AuthState>()

   suspend fun login(credentials: Credentials) {
                  loginusecase.execute(LoginUseCase.Request(credentials.mail, credentials.password))
                      .map {
                           EntityMapper.convert(it)
                      }.onEach {
                          when(it)
                          {
                              is UiState.Success-> {
                                  _user.value = AuthState(it.data as User)
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
        Log.i(" regisdter", "submit: $credentials")

            viewModelScope.launch {
                signUpUseCase.process(SignUpUseCase.Request(User(credentials.mail, credentials.password)))
                    .map {
                        Log.i(" register viewmodal ", "submit: $it")
                        EntityMapper.convertToAuthState(it)
                    }.onEach {
                        when (it) {
                            is UiState.Success -> {
                                _user.value = AuthState(data = it.data as User)
                            }
                            is UiState.Error -> {
                                _user.value = AuthState(error = it.errorMessage)
                            }
                            is UiState.Loading -> {
                                _user.value = AuthState(isLoading = true)
                            }
                            else -> {
                                    // do nthing why should i care about other states
                            }
                        }
                    }
            }
    }


}