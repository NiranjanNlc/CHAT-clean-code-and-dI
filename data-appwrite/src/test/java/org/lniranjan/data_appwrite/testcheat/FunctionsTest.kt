package io.appwrite.servicesTest

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import io.appwrite.Client
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Functions
import java.io.File

suspend fun main() {
    val client = Client()
        .setProject("[YOUR_PROJECT_ID]")
        .setEndpoint("[YOUR_ENDPOINT]")
        .setKey("[YOUR_KEY]")

    val functions = Functions(client)

    listTest(functions)
    createTest(functions)
    getTest(functions)
    updateTest(functions)
    deleteTest(functions)
    listexecutionsTest(functions)
    createexecutionTest(functions)
    getexecutionTest(functions)
    updatetagTest(functions)
    listtagsTest(functions)
    createtagTest(functions)
    gettagTest(functions)
    deletetagTest(functions)

}

suspend fun listTest(functions: Functions) {
    try {
        val response = functions.list(
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createTest(functions: Functions) {
    try {
        val response = functions.create(
                name = "[NAME]",
                execute = listOf(),
                env = "dotnet-3.1",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getTest(functions: Functions) {
    try {
        val response = functions.get(
                functionId = "[FUNCTION_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updateTest(functions: Functions) {
    try {
        val response = functions.update(
                functionId = "[FUNCTION_ID]",
                name = "[NAME]",
                execute = listOf(),
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun deleteTest(functions: Functions) {
    try {
        val response = functions.delete(
                functionId = "[FUNCTION_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun listexecutionsTest(functions: Functions) {
    try {
        val response = functions.listExecutions(
                functionId = "[FUNCTION_ID]",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createexecutionTest(functions: Functions) {
    try {
        val response = functions.createExecution(
                functionId = "[FUNCTION_ID]",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getexecutionTest(functions: Functions) {
    try {
        val response = functions.getExecution(
                functionId = "[FUNCTION_ID]",
                executionId = "[EXECUTION_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updatetagTest(functions: Functions) {
    try {
        val response = functions.updateTag(
                functionId = "[FUNCTION_ID]",
                tag = "[TAG]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun listtagsTest(functions: Functions) {
    try {
        val response = functions.listTags(
                functionId = "[FUNCTION_ID]",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createtagTest(functions: Functions) {
    try {
        val response = functions.createTag(
                functionId = "[FUNCTION_ID]",
                command = "[COMMAND]",
                code = File("./path-to-files/image.jpg")
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun gettagTest(functions: Functions) {
    try {
        val response = functions.getTag(
                functionId = "[FUNCTION_ID]",
                tagId = "[TAG_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun deletetagTest(functions: Functions) {
    try {
        val response = functions.deleteTag(
                functionId = "[FUNCTION_ID]",
                tagId = "[TAG_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}








