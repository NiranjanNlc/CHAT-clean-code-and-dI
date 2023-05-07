package org.lniranjan.data_appwrite.conversation

interface ConversationRepository {
    fun createConversation(conversation: Conversation): Conversation
    fun getConversationById(id: String): Conversation?
    fun updateConversation(id: String, updatedConversation: Conversation): Conversation?
    fun deleteConversation(id: String)
}

data class Conversation(val id: String, val name: String)

class ConversationService(private val conversationRepository: ConversationRepository) {
    fun createConversation(conversation: Conversation): Conversation {
        return conversationRepository.createConversation(conversation)
    }

    fun getConversationById(id: String): Conversation? {
        return conversationRepository.getConversationById(id)
    }

    fun updateConversation(id: String, updatedConversation: Conversation): Conversation? {
        return conversationRepository.updateConversation(id, updatedConversation)
    }

    fun deleteConversation(id: String) {
        conversationRepository.deleteConversation(id)
    }
}
