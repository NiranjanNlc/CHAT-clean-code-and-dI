package org.lniranjan.domain.entity

data class ProfileDetail(val profilePic:String?=null,
                         var bio:String?=null,
                         val userName:String?=null,
                         val user: User)