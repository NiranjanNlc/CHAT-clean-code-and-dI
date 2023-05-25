package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.lniranjan.chatclone.modal.MessageItem
import org.lniranjan.domain.usecases.chat.GetListofMessage
import org.lniranjan.domain.usecases.chat.SendMessage
import org.lniranjan.domain.usecases.chat.UpdateMessage
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val sendMessage: SendMessage,
    private val getListofMessage: GetListofMessage,
    private val updateMessage: UpdateMessage
):ViewModel()
{
    val _messageList = MutableLiveData<List<MessageItem>>()
    val messageList: LiveData<List<MessageItem>>
        get() = _messageList
    fun sendMessage(newMessage: MessageItem)
    {
        val currentMessages = _messageList.value.orEmpty().toMutableList()
        currentMessages.add(newMessage)
        _messageList.value = currentMessages
        viewModelScope.launch {
        }
    }
    fun updateMessage(message: MessageItem)
    {
        viewModelScope.launch {

        }
    }
    fun getListOfMessage(message: MessageItem)
    {

        viewModelScope.launch {

        }
    }
    fun deleteAllMessages() {
        _messageList.postValue(emptyList())
    }
}
