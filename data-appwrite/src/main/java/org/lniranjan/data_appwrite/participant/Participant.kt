package org.lniranjan.data_appwrite.participant

interface ParticipantRepository {
    fun addParticipant(participant: Participant): Participant
    fun getParticipantById(id: String): Participant?
    fun updateParticipant(id: String, updatedParticipant: Participant): Participant?
    fun deleteParticipant(id: String)
}

data class Participant(val id: String, val userId: String, val conversationId: String)

class ParticipantService(private val participantRepository: ParticipantRepository) {
    fun addParticipant(participant: Participant): Participant {
        return participantRepository.addParticipant(participant)
    }

    fun getParticipantById(id: String): Participant? {
        return participantRepository.getParticipantById(id)
    }

    fun updateParticipant(id: String, updatedParticipant: Participant): Participant? {
        return participantRepository.updateParticipant(id, updatedParticipant)
    }

    fun deleteParticipant(id: String) {
        participantRepository.deleteParticipant(id)
    }
}
