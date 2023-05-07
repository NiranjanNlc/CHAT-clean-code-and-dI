package org.lniranjan.data_appwrite.users

interface UserRepository {
    fun createUser(user: User): User
    fun getUserById(id: String): User?
    fun updateUser(id: String, updatedUser: User): User?
    fun deleteUser(id: String)
}

data class User(val id: String, val username: String, val password: String)

class UserService(private val userRepository: UserRepository) {
    fun createUser(user: User): User {
        return userRepository.createUser(user)
    }

    fun getUserById(id: String): User? {
        return userRepository.getUserById(id)
    }

    fun updateUser(id: String, updatedUser: User): User? {
        return userRepository.updateUser(id, updatedUser)
    }

    fun deleteUser(id: String) {
        userRepository.deleteUser(id)
    }
}
