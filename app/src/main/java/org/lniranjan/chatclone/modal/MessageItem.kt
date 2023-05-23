package org.lniranjan.chatclone.modal

import kotlin.random.Random


// data class mssage containg message and sender and timestamp
data class MessageItem(
    //generate the random id of message
    val id: Int = Random.nextInt(),
    val message: String? =" Hello Niranjan Babby ",
    val sender: String? = "Niranjan",
    val timestamp: String = "10: 58 pm , `12/12/2020`"
)