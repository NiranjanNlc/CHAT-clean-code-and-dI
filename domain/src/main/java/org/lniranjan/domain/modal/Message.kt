package org.lniranjan.domain.modal

data class Message( val emoji: String?= null,
                        val text: String?=null,
                        val senderId: String?=null,
                        val receiverId: String?=null,
                        val timeStamp: Long=0
)