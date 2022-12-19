package org.lniranjan.data.source.firebase

import android.net.Uri
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.User
import javax.inject.Inject

class FireBaseProFile  @Inject constructor(   
    private val rootRef : DatabaseReference,
    private val storageRef : StorageReference
) {
    fun updateProfile(profileDetail: User): Flow<Boolean> {
        return flow {
            rootRef.child("users").child(profileDetail.userId !!).setValue(profileDetail).await()
            emit(true)
        }
    }

    fun getProfile(user: String): Flow<User> {
        return flow {
            rootRef.child("users").child(user).get()
                .await().children
                .map {
                    val profileDetail = it.getValue(User::class.java)
                    if (profileDetail != null) {
                        emit(profileDetail)
                    }
                }
        }
    }

    fun updateProfilePhoto(resultUri: String , currentUserId: String): Flow<Boolean> {
        Log.i("TAG", " updateProfilePhoto: $currentUserId")
        return flow {
            val filePath = storageRef.child(currentUserId)
            val photoUrl1 = filePath.putFile(Uri.parse(resultUri)).await()
            Log.i("photourl1", " photourl1 updateProfilePhoto: $photoUrl1")
            val photoUrl = photoUrl1.storage.downloadUrl.await()
            Log.i("photourl1", " photourl  updateProfilePhoto: $photoUrl")
            val result = rootRef.child("users")
                .child(currentUserId)
                .child("profilePhoto")
                .setValue(photoUrl.toString())
            result.await()
            if (result.isSuccessful) {
                emit(true)
            } else
            {
                emit(false)
                Log.i("photourl1", " photourl  updateProfilePhoto: $result")

            }
        }

    }
}