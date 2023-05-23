package org.lniranjan.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lniranjan.data.source.firebase.FireBaseProFile
import org.lniranjan.data.source.firebase.FirebaseAuthenciation
import org.lniranjan.domain.repo.Authenciation

@Module
@InstallIn(SingletonComponent::class)
class FireBaseModule {


    @Provides
    fun provideAuthRepo (firebaseAuthenciation: FirebaseAuth ): Authenciation
            = FirebaseAuthenciation(firebaseAuthenciation)

    @Provides
    fun provideFireBaseAuth (): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideFireBaseDataBase (): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    fun provideFireBaseStorage (): StorageReference {
        return FirebaseStorage.getInstance().reference
    }

    @Provides
    fun provideFireBaseReference (database : FirebaseDatabase): DatabaseReference {
        return database.reference
    }

    @Provides
    fun provideFireBaseProfile (
        reference: DatabaseReference ,
    storageReference: StorageReference): FireBaseProFile {
        return FireBaseProFile(reference,
                                    storageReference)
    }

}
