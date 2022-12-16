package org.lniranjan.data.repo

import kotlinx.coroutines.flow.Flow
import org.lniranjan.data.source.firebase.FireBaseProFile
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Profile

class ProfileImpl( private val firebaseProfile : FireBaseProFile) : Profile {


    override fun updateProfile(profileDetail: User): Flow<Boolean> {
          return firebaseProfile.updateProfile(profileDetail)
        }

    override fun getProfile(user: User): Flow<User> {
         return firebaseProfile.getProfile(user)
    }
}



