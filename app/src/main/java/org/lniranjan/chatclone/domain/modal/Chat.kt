package org.lniranjan.chatclone.domain.modal

data class Chat(val lastTimeStamp: Long? =null,
                var chatingPerson :User?=null,
                val lastmessage :String?=null)
