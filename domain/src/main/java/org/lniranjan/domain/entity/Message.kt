package org.lniranjan.domain.entity

data class Message( val emoji: String?= null,
                        val text: String?=null,
                        val senderId: String?=null,
                        val receiverId: String?=null,
                        val timeStamp: Long=0,
                        val id : Long
)