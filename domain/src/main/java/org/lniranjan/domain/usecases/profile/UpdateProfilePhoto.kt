package org.lniranjan.domain.usecases.profile

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.ProfileDetail
import org.lniranjan.domain.repo.Profile
import org.lniranjan.domain.usecases.UseCase

class UpdateProfilePhoto (
    configuration: Configuration,
    private val  profile: Profile
    ) : UseCase<UpdateProfilePhoto .Request, UpdateProfilePhoto .Response>(configuration) {
        data class Request(val updatedProfile: ProfileDetail) : UseCase.Request
        data class Response(val updateStatus: Boolean) : UseCase.Response
        override suspend fun process(request: Request): Flow<Response> =
            profile.updateProfile(request.updatedProfile)
                .map {
                    Response(it)
                }
    }