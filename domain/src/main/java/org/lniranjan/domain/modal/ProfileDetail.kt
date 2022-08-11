package org.lniranjan.domain.modal

data class ProfileDetail(val profilePic:String?=null,
                         var bio:String?=null,
                         val userName:String?=null,
                         val user: User)