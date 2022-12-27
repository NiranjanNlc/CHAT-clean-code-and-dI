package org.lniranjan.domain.entity

data class Chat(val lastTimeStamp: Long? =null,
                var chatingPerson :User?=null,
                val lastmessage :String="",)
