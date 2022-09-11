package org.lniranjan.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lniranjan.data.repo.AuthenticationImpl
import org.lniranjan.data.source.firebase.FirebaseAuthenciation
import org.lniranjan.domain.repo.Authenciation


@Module
@InstallIn(SingletonComponent::class)
class FireBaseModule {

    @Provides
    fun provideFireBaseAuth (): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    fun provideFireBaseDataBase (): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    fun provideFireBaseStorage (): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }
}
