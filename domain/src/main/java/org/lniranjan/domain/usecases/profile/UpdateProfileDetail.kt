package org.lniranjan.domain.usecases.profile

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.entity.ProfileDetail
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Profile
import org.lniranjan.domain.usecases.UseCase

class UpdateProfileDetail (
    configuration: Configuration,
    private val  profile: Profile
) : UseCase<UpdateProfileDetail.Request, UpdateProfileDetail.Response>(configuration) {
    data class Request(val updatedProfile: ProfileDetail) : UseCase.Request
    data class Response(val updateStatus: Boolean) : UseCase.Response

    override suspend fun process(request: Request): Flow<Response> =
        profile.updateProfile(request.updatedProfile)
            .map {
                Response(it)
            }
}