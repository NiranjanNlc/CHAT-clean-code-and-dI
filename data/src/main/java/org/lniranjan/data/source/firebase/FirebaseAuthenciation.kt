package org.lniranjan.data.source.firebase

import android.util.Log
import org.lniranjan.domain.entity.Result as Result1
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation
import javax.inject.Inject

class FirebaseAuthenciation @Inject constructor(  val firebaseAuth: FirebaseAuth) : Authenciation {
    override suspend fun login(email: String, password: String): Flow<Boolean> {
        return flow {
            if (firebaseAuth.signInWithEmailAndPassword(email, password)?.await()?.user!= null) {
                emit(true)
            }
            emit(false)
        }
    }

    override fun logout(): Flow<Boolean> {
        return flow {
            firebaseAuth.signOut()
            emit(true)
        }
    }


    override fun getUser(): Flow<User> {
         return flow {
                val user = firebaseAuth.currentUser
             user?.let { User(it.uid,it.email!!) }?.let { emit(it) }
         }
    }

    override suspend fun signUp(user: User): Flow<User> = firebaseAuth.createUserWithEmailAndPassword(user.mail,user.password).
    await()
        .user?.let { User(it.uid,it.email!!) }?.let { flow { emit(it) } }!!
}
