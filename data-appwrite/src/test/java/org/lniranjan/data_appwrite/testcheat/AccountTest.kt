package org.lniranjan.data_appwrite.testcheat

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import io.appwrite.Client
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Account
import org.junit.Before
import org.lniranjan.data_appwrite.PROJECT

class AccountTest {
    private lateinit var appContext: Context
    private lateinit var client: Client

    @Before
    @Throws(Exception::class)
    fun setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext()
        client = Client(appContext)
            .setEndpoint(PROJECT.endpoint)
            .setProject(PROJECT.projectId)
            .setSelfSigned(true)
    }

    suspend fun main() {
        val account = Account(client)

        getTest(account)
        deleteTest(account)
        updateemailTest(account)
        getlogsTest(account)
        updatenameTest(account)
        updatepasswordTest(account)
        getprefsTest(account)
        updateprefsTest(account)
        createrecoveryTest(account)
        updaterecoveryTest(account)
        getsessionsTest(account)
        deletesessionsTest(account)
        deletesessionTest(account)
        createverificationTest(account)
        updateverificationTest(account)

    }

    suspend fun getTest(account: Account) {
        try {
            val response = account.get()
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun deleteTest(account: Account) {
        try {
            val response = account.deleteSessions()
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun updateemailTest(account: Account) {
        try {
            val response = account.updateEmail(
                email = "email@example.com",
                password = "password"
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun getlogsTest(account: Account) {
        try {
            val response = account.listLogs()
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun updatenameTest(account: Account) {
        try {
            val response = account.updateName(
                name = "[NAME]"
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun updatepasswordTest(account: Account) {
        try {
            val response = account.updatePassword(
                password = "password",
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun getprefsTest(account: Account) {
        try {
            val response = account.getPrefs()
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun updateprefsTest(account: Account) {
        try {
            val response = account.updatePrefs(
                prefs = mapOf("a" to "b")
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun createrecoveryTest(account: Account) {
        try {
            val response = account.createRecovery(
                email = "email@example.com",
                url = "https://example.com"
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun updaterecoveryTest(account: Account) {
        try {
            val response = account.updateRecovery(
                userId = "[USER_ID]",
                secret = "[SECRET]",
                password = "password",
                passwordAgain = "password"
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun getsessionsTest(account: Account) {
        try {
            val response = account.getSession("sessionId")
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun deletesessionsTest(account: Account) {
        try {
            val response = account.deleteSessions()
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun deletesessionTest(account: Account) {
        try {
            val response = account.deleteSession(
                sessionId = "[SESSION_ID]"
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun createverificationTest(account: Account) {
        try {
            val response = account.createVerification(
                url = "https://example.com"
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

    suspend fun updateverificationTest(account: Account) {
        try {
            val response = account.updateVerification(
                userId = "[USER_ID]",
                secret = "[SECRET]"
            )
            var jsonString = response.toString()?: ""
            val gson = GsonBuilder().setPrettyPrinting().create()
            val je: JsonElement = JsonParser().parse(jsonString)
            println(gson.toJson(je))
        } catch (e: AppwriteException) {
            println(e)
        }
    }

}






