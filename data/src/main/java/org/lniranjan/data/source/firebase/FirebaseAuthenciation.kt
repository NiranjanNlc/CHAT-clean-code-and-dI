package org.lniranjan.data.source.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
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

    override suspend fun signUp(user: User): Result<User?> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(user.mail,user.password).
            await()
                .user?.
                let {
                    User(userId = it.uid, mail = it.email!!, userName = it.displayName )
                }
            Result.success(result)
        } catch (e :Exception){
            println(e.message)
            Result.failure(e)
        }
    }
    }
