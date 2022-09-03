package org.lniranjan.chatclone.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.usecases.chat.GetListofContacts
import javax.inject.Inject

class ContactViewModel @Inject constructor(
    private val getListofContacts: GetListofContacts
) : ViewModel()
{

    fun getListOfContacts(user: User)
    {
        viewModelScope.launch{
            getListofContacts.process(GetListofContacts.Request(user))
        }
    }
}