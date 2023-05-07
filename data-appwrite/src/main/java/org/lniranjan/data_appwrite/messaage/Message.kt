package org.lniranjan.data_appwrite.messaage
interface MessageRepository {
    fun sendMessage(message: Message): Message
    fun getMessageById(id: String): Message?
    fun updateMessage(id: String, updatedMessage: Message): Message?
    fun deleteMessage(id: String)
}

data class Message(val id: String, val conversationId: String, val senderId: String, val content: String, val timestamp: Long)

class MessageService(private val messageRepository: MessageRepository) {
    fun sendMessage(message: Message): Message {
        return messageRepository.sendMessage(message)
    }

    fun getMessageById(id: String): Message? {
        return messageRepository.getMessageById(id)
    }

    fun updateMessage(id: String, updatedMessage: Message): Message? {
        return messageRepository.updateMessage(id, updatedMessage)
    }

    fun deleteMessage(id: String) {
        messageRepository.deleteMessage(id)
    }
}
