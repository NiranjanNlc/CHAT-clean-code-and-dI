package org.lniranjan.domain.entity

import java.util.*

data class User(val mail:String = "fuckboy@gmail.com",
                val password : String ="hhh",
                val profilePic:String?=null ,
                val userName:String?=null ,
                var userId:String?=null,
                var bio:String?=null
                )
