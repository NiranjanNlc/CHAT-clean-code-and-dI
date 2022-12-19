package org.lniranjan.data.source.firebase

import android.net.Uri
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.User
import java.net.URI
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

    fun getProfile(user: User): Flow<User> {
        return flow {
            rootRef.child("users").child(user.userId!!).get()
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
        return flow {
            val filePath = storageRef.child(currentUserId)
            val photoUrl= filePath.putFile(Uri.parse(resultUri)).result.uploadSessionUri?.path
            if (photoUrl != null) {
                rootRef.child("users").child(currentUserId).child("profilePhoto").setValue(photoUrl).await()
                emit(true)
            }
        }
    }
}