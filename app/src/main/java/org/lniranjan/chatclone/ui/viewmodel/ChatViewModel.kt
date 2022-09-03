package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.usecases.chat.GetListofChat
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val getListofChat: GetListofChat
): ViewModel()
{

    fun getListOfChats(user: User)
    {
        viewModelScope.launch {
            getListofChat.process(GetListofChat.Request(user))
        }
    }
}