package org.lniranjan.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lniranjan.data.source.firebase.FirebaseAuthenciation
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation

class AuthenticationImpl(private val firebaseAuthenciation: FirebaseAuthenciation) : Authenciation{

    override suspend fun login(email: String?, password: String): Flow<Boolean> {
          return flow {
              if (firebaseAuthenciation.login(email, password)?.user != null) {
                  emit(true)
              }
              emit(false)
          }
    }

    override fun logout(user: User): Flow<Boolean> {
        return  firebaseAuthenciation.logout(user)
    }

    override fun sighnUp(user: User): Flow<User> {
       return flow {
            (firebaseAuthenciation.sighnUp(user)?.user)
       }
    }

    override fun getUser(): Flow<User> {
        return firebaseAuthenciation.getUser()
    }

}