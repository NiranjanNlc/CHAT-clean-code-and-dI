package org.lniranjan.chatclone.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lniranjan.data.repo.AuthenticationImpl
import org.lniranjan.data.repo.ChattingImpl
import org.lniranjan.data.repo.MessagingImpl
import org.lniranjan.data.repo.ProfileImpl
import org.lniranjan.data.source.firebase.FireBaseChats
import org.lniranjan.data.source.firebase.FireBaseProFile
import org.lniranjan.data.source.firebase.FirebaseAuthenciation
import org.lniranjan.data.source.firebase.Firebasemessaging
import org.lniranjan.domain.repo.Chatting
import org.lniranjan.domain.repo.Messaging


@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    fun provideAuthRepo(
        authenicationService: FirebaseAuthenciation )
            = AuthenticationImpl(authenicationService)
    @Provides
    fun provideChatRepo(
        chats: FireBaseChats)
            = ChattingImpl(chats)
    @Provides
    fun provideMessageRepo(
        messaging: Firebasemessaging)
            = MessagingImpl( messaging)
    @Provides
    fun provideProfileRepo( fireBaseProFile: FireBaseProFile)
            = ProfileImpl(fireBaseProFile)
}