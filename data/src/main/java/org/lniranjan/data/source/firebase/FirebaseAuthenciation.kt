package org.lniranjan.data.source.firebase

import kotlinx.coroutines.flow.Flow
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation

class FirebaseAuthenciation  : Authenciation {
    override fun login(email: String?, passwrd: String): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun logout(user: User): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun sighnUp(user: User): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}