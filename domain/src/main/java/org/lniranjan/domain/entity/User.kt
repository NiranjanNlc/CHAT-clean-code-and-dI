package org.lniranjan.domain.entity

import java.util.*

data class User(val mail:String,
                val password : String ="hhh",
                val profilePic:String?=null ,
                val userName:String?=null ,
                var userId:String = (Random().nextInt(9999910) + 1).toString(),
                var bio:String?=null
                )
