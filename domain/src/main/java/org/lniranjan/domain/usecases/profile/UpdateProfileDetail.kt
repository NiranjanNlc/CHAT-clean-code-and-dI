package org.lniranjan.domain.usecases.profile

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.domain.repo.Profile
import org.lniranjan.domain.usecases.UseCase
import javax.inject.Inject

class UpdateProfileDetail @Inject constructor (
    configuration: Configuration,
    private val  profile: Profile
) : UseCase<UpdateProfileDetail.Request, UpdateProfileDetail.Response>(configuration) {
    data class Request(val updatedProfile: HashMap<String, String>, val userid: String) : UseCase.Request
    data class Response(val updateStatus: Boolean) : UseCase.Response

    override suspend fun process(request: Request): Flow<Response> =
        profile.updateProfile(request.updatedProfile,request.userid)
            .map {
                Response(it)
            }
}