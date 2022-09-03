package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.lniranjan.domain.entity.Message
import org.lniranjan.domain.usecases.chat.GetListofMessage
import org.lniranjan.domain.usecases.chat.SendMessage
import org.lniranjan.domain.usecases.chat.UpdateMessage
import javax.inject.Inject

class MessageViewModel @Inject constructor(
    private val sendMessage: SendMessage,
    private val getListofMessage: GetListofMessage,
    private val updateMessage: UpdateMessage
):ViewModel()
{
    fun sendMessage(message: Message)
    {
        viewModelScope.launch {

        }
    }
    fun updateMessage(message: Message)
    {
        viewModelScope.launch {

        }
    }
    fun getListOfMessage(message: Message)
    {
        viewModelScope.launch {

        }
    }


}