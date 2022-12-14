package org.lniranjan.data.repo
//
//import android.util.Log
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.UserProfileChangeRequest
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.catch
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.tasks.await
//import org.lniranjan.data.source.firebase.FirebaseAuthenciation
//import org.lniranjan.domain.R
//import org.lniranjan.domain.entity.Resource
//import org.lniranjan.domain.entity.User
//import org.lniranjan.domain.repo.Authenciation
//
//class AuthenticationImpl(private val firebaseAuthenciation: FirebaseAuthenciation) : Authenciation{
//
//    override suspend fun login(email: String, password: String): Flow<Boolean> {
//          return flow {
//              if (firebaseAuthenciation.login(email, password)?.await()?.user!= null) {
//                  emit(true)
//              }
//              emit(false)
//          }
//    }
//
//    override fun logout(): Flow<Boolean> {
//        return  firebaseAuthenciation.logout()
//    }
//
//    override fun sighnUp(user: User): Flow<User> {
//        Log.d("TAG", "sighnUp: ${user.mail}, ${user.password}")
//       return flow {
//           emit (firebaseAuthenciation.sighnUp(user)?.await()?.user!!.let {
//               User(it.uid,it.uid, it.displayName, it.phoneNumber)
//           })
//       }
//           .catch {
//                Log.d("TAG", "sighnUp: ${it.message}")
//           }
//    }
//
//    override fun getUser(): Flow<User> {
//        return firebaseAuthenciation.getUser()
//    }
//
//    override suspend fun signUp(user: User): Resource<out R> {
//        return try {
//            val result = firebaseAuthenciation.sighnUp(user)?.await()
//            result?.user?.updateProfile(
//                UserProfileChangeRequest.Builder().setDisplayName(user.userName).build()
//            )?.await()
//            Resource.Success(result?.user!!)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Resource.Failure(e)
//        }    }
//
//    override suspend fun signup(user: User): Resource<out R> {
//        return try {
//            val result = firebaseAuthenciation.sighnUp(user)?.await()
//            result?.user?.updateProfile(
//                UserProfileChangeRequest.Builder().setDisplayName(user.userName).build()
//            )?.await()
//            Resource.Success(result?.user!!)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Resource.Failure(e)
//        }
//    }
//    }