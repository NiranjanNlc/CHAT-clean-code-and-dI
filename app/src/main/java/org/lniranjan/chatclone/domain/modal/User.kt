package org.lniranjan.chatclone.domain.modal

import java.util.*

data class User(val mail:String?=null,
                val password : String ="hhh",
                var userId:String = (Random().nextInt(9999910) + 1).toString(),
                )
