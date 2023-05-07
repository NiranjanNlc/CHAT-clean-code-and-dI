package io.appwrite.servicesTest

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import io.appwrite.Client
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Teams


suspend fun main() {
    val client = Client()
        .setProject("[YOUR_PROJECT_ID]")
        .setEndpoint("[YOUR_ENDPOINT]")
        .setKey("[YOUR_KEY]")

    val teams = Teams(client)

    listTest(teams)
    createTest(teams)
    getTest(teams)
    updateTest(teams)
    deleteTest(teams)
    getmembershipsTest(teams)
    createmembershipTest(teams)
    updatemembershiprolesTest(teams)
    deletemembershipTest(teams)
    updatemembershipstatusTest(teams)

}

suspend fun listTest(teams: Teams) {
    try {
        val response = teams.list(
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createTest(teams: Teams) {
    try {
        val response = teams.create(
                name = "[NAME]",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getTest(teams: Teams) {
    try {
        val response = teams.get(
                teamId = "[TEAM_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updateTest(teams: Teams) {
    try {
        val response = teams.update(
                teamId = "[TEAM_ID]",
                name = "[NAME]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun deleteTest(teams: Teams) {
    try {
        val response = teams.delete(
                teamId = "[TEAM_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getmembershipsTest(teams: Teams) {
    try {
        val response = teams.getMemberships(
                teamId = "[TEAM_ID]",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createmembershipTest(teams: Teams) {
    try {
        val response = teams.createMembership(
                teamId = "[TEAM_ID]",
                email = "email@example.com",
                roles = listOf(),
                url = "https://example.com",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updatemembershiprolesTest(teams: Teams) {
    try {
        val response = teams.updateMembershipRoles(
                teamId = "[TEAM_ID]",
                membershipId = "[MEMBERSHIP_ID]",
                roles = listOf()
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun deletemembershipTest(teams: Teams) {
    try {
        val response = teams.deleteMembership(
                teamId = "[TEAM_ID]",
                membershipId = "[MEMBERSHIP_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updatemembershipstatusTest(teams: Teams) {
    try {
        val response = teams.updateMembershipStatus(
                teamId = "[TEAM_ID]",
                membershipId = "[MEMBERSHIP_ID]",
                userId = "[USER_ID]",
                secret = "[SECRET]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}








