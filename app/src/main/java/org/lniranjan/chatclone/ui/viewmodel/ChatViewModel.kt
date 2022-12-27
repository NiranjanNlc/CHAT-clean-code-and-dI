package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.lniranjan.chatclone.modal.ChatItem
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.usecases.auth.CurrentUserUsecase
import org.lniranjan.domain.usecases.chat.GetListofChat
import org.lniranjan.domain.usecases.profile.GetProfileDetail
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val getListofChat: GetListofChat,
    val currentUsercase : CurrentUserUsecase
): ViewModel()
{
    val currentuserId = MutableLiveData<String>()
    val chatList =MutableLiveData<List<ChatItem>>()

    init {
        if (getCurrentUser().isCompleted)
            getChatList()
        }

    fun getCurrentUser() = viewModelScope.launch {
        currentUsercase.process(CurrentUserUsecase.Request("")).first().profile?.let {
            currentuserId.value = it
        }
    }

    fun getChatList() = viewModelScope.launch {
        getListofChat.process(GetListofChat.Request(currentuserId.value!!))
            .map {
                it.chatList.map { chat ->
                    ChatItem(userphoto = chat.chatingPerson?.profilePic,
                        username = chat.chatingPerson?.userName!!,
                         lastMessage = chat.lastmessage)
                }
            }.first().let {
                chatList.postValue(it)
            }
    }
}