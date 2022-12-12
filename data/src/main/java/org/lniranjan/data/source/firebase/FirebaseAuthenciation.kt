package org.lniranjan.data.source.firebase

import android.util.Log
import org.lniranjan.domain.entity.Result as Result1
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.UseCaseException
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation
import javax.inject.Inject

class FirebaseAuthenciation @Inject constructor(  val firebaseAuth: FirebaseAuth) : Authenciation {
    override suspend fun login(email: String, password: String):Flow<Result1<Any>> {
        return try{
            firebaseAuth.signInWithEmailAndPassword(email, password)?.await()
                ?.user?.let { User(userId = it.uid, mail = it.email!!) }
            ?.let {
                Log.i("SignUpUseCase hjjj", "process: $it")
                flow { emit(Result1.Success(it)) }
            }!!
        }
        catch (e:Exception)
        {
            Log.e("FirebaseAuthenciation", "Error in FirebaseAuthenciation"+ e.message)
            flow { emit(Result1.Error(UseCaseException.createFromThrowable(e))) }
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
            user?.let { User(it.uid, it.email!!) }?.let { emit(it) }
        }
    }

    override suspend fun signUp(user: User): Flow<Result1<Any>> {
        Log.i("SignUpUseCase", "process: $user")
        return try {
            firebaseAuth.createUserWithEmailAndPassword(user.mail, user.password).await()
                .user?.let { User(userId = it.uid,mail = it.email!!) }
                ?.let {
                    Log.i("SignUpUseCase hjjj" , "process: $it")
                    flow { emit(Result1.Success(it)) } }!!
        } catch (e: Exception) {
            Log.e("FirebaseAuthenciation", "Error in FirebaseAuthenciation"+ e.message)
            flow { emit(Result1.Error(UseCaseException.createFromThrowable(e))) }
        }
    }
}
