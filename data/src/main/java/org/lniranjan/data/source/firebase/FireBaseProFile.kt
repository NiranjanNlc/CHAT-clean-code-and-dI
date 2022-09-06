package org.lniranjan.data.source.firebase

import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.lniranjan.domain.entity.ProfileDetail
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Profile
import javax.inject.Inject

class FireBaseProFile  @Inject constructor(   
    private val rootRef : DatabaseReference
) 
{
     fun updateProfile(profileDetail: ProfileDetail): Flow<Boolean> {
        return flow {
            rootRef.child("users").child(profileDetail.userName!!).setValue(profileDetail).await()
            emit(true)
        }
    }

     fun getProfile(user: User): Flow<ProfileDetail> { 
        return flow {
            rootRef.child("users").child(user.userId).
            get()
                .await().children
                .map {
                    val profileDetail = it.getValue(ProfileDetail::class.java)
                    if (profileDetail != null) {
                        emit(profileDetail)
                    }
                }
            }
        }
}