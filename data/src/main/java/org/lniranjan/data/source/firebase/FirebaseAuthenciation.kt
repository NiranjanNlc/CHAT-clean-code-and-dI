package org.lniranjan.data.source.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.User
import javax.inject.Inject

class FirebaseAuthenciation @Inject constructor(  val firebaseAuth: FirebaseAuth
) {
    fun login(email: String, password: String): Task<AuthResult>? {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email!!,password)
        } catch (e :Exception){
            e.printStackTrace()
            null
        }
    }

    fun logout(): Flow<Boolean> {
        return flow {
            firebaseAuth.signOut()
            emit(true)
        }
    }

     fun sighnUp(user: User): Task<AuthResult>? {
         return try {
             val result = firebaseAuth.createUserWithEmailAndPassword(user.mail,user.password)
             println(result)
             result
         } catch (e :Exception){
             println(e.message)
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