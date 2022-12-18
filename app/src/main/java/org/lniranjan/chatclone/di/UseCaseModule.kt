package org.lniranjan.chatclone.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import org.lniranjan.data.repo.ProfileImpl
import org.lniranjan.data.source.firebase.FireBaseProFile
import org.lniranjan.domain.repo.Authenciation
import org.lniranjan.domain.repo.Chatting
import org.lniranjan.domain.repo.Messaging
import org.lniranjan.domain.repo.Profile
import org.lniranjan.domain.usecases.UseCase
import org.lniranjan.domain.usecases.auth.LoginUseCase
import org.lniranjan.domain.usecases.auth.SignOutUseCase
import org.lniranjan.domain.usecases.auth.SignUpUseCase
import org.lniranjan.domain.usecases.chat.*
import org.lniranjan.domain.usecases.profile.GetProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfileDetail
import org.lniranjan.domain.usecases.profile.UpdateProfilePhoto

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCaseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun providesLoginUseCase(
        configuration: UseCase.Configuration,
        authenciation: Authenciation
    ): LoginUseCase= LoginUseCase(configuration, authenciation)

    @Provides
    fun providesSighnUpUseCase(
        configuration: UseCase.Configuration,
        authenciation: Authenciation
    ): SignUpUseCase= SignUpUseCase(configuration, authenciation)

    @Provides
    fun providesSignOUtUseCase(
        configuration: UseCase.Configuration,
        authenciation: Authenciation
    ): SignOutUseCase= SignOutUseCase(configuration, authenciation)

    @Provides
    fun providesListOfChatUseCase(
        configuration: UseCase.Configuration,
        chatting: Chatting
    ): GetListofChat= GetListofChat(configuration, chatting)

    @Provides
    fun providesListOfContactUseCase(
        configuration: UseCase.Configuration,
        chatting: Chatting
    ):GetListofContacts = GetListofContacts(configuration, chatting)

    @Provides
    fun providesListOfMessageUseCase(
        configuration: UseCase.Configuration,
        messaging: Messaging
    ): GetListofMessage = GetListofMessage(configuration, messaging)

    @Provides
    fun providesSendMessageUseCase(
        configuration: UseCase.Configuration,
        messaging: Messaging
    ): SendMessage = SendMessage(configuration, messaging)

    @Provides
    fun providesUpdateMessageUseCase(
        configuration: UseCase.Configuration,
        messaging: Messaging
    ): UpdateMessage = UpdateMessage(configuration, messaging)

    @Provides
    fun providesProfileDetailUseCase(
        configuration: UseCase.Configuration,
        profile: Profile
    ): GetProfileDetail = GetProfileDetail(configuration, profile)

    @Provides
    fun providesUpdateProfileUseCase(
        configuration: UseCase.Configuration,
        profile: Profile
    ): UpdateProfileDetail = UpdateProfileDetail(configuration, profile)


    @Provides
    fun providesUpdateProfilephotoUseCase(
        configuration: UseCase.Configuration,
        profile: Profile
    ): UpdateProfilePhoto= UpdateProfilePhoto(configuration, profile)

    @Provides
    fun providesProfile (
     fireBaseProFile: FireBaseProFile
    ) : Profile= ProfileImpl(fireBaseProFile)
}