package org.lniranjan.data.source.firebase

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation
import javax.inject.Inject

class FirebaseAuthenciation @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    suspend fun login(email: String?, password: String): AuthResult? {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email!!,password).await()
            result
        } catch (e :Exception){
            e.printStackTrace()
            null
        }
    }

    fun logout(user: User): Flow<Boolean> {
        return flow {
            firebaseAuth.signOut()
            emit(true)
        }
    }

     suspend fun sighnUp(user: User): AuthResult?{
         return try {
             val result = firebaseAuth.createUserWithEmailAndPassword(user.mail,user.password)
                 .await()
             result
         } catch (e :Exception){
                e.printStackTrace()
             null
         }
    }

    fun getUser(): Flow<User> {
         return flow {
                val user = firebaseAuth.currentUser
             user?.let { User(it.uid,it.email!!) }?.let { emit(it) }
         }
    }
}