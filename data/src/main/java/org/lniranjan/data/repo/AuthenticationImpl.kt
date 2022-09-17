package org.lniranjan.data.repo

import android.util.Log
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
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
        Log.d("TAG", "sighnUp: ${user.mail}, ${user.password}")
       return flow {
           emit (firebaseAuthenciation.sighnUp(user)?.user!!.let {
               User(it.uid,it.uid, it.displayName, it.phoneNumber)
           })
       }
           .catch {
                Log.d("TAG", "sighnUp: ${it.message}")
           }
    }

    override fun getUser(): Flow<User> {
        return firebaseAuthenciation.getUser()
    }

}