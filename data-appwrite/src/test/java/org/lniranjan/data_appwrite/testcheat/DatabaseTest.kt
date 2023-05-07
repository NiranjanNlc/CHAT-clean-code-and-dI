package io.appwrite.servicesTest

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import io.appwrite.Client
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Database


suspend fun main() {
    val client = Client()
        .setProject("[YOUR_PROJECT_ID]")
        .setEndpoint("[YOUR_ENDPOINT]")
        .setKey("[YOUR_KEY]")

    val database = Database(client)

    listcollectionsTest(database)
    createcollectionTest(database)
    getcollectionTest(database)
    updatecollectionTest(database)
    deletecollectionTest(database)
    listdocumentsTest(database)
    createdocumentTest(database)
    getdocumentTest(database)
    updatedocumentTest(database)
    deletedocumentTest(database)

}

suspend fun listcollectionsTest(database: Database) {
    try {
        val response = database.listCollections(
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createcollectionTest(database: Database) {
    try {
        val response = database.createCollection(
                name = "[NAME]",
                read = listOf(),
                write = listOf(),
                rules = listOf()
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getcollectionTest(database: Database) {
    try {
        val response = database.getCollection(
                collectionId = "[COLLECTION_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updatecollectionTest(database: Database) {
    try {
        val response = database.updateCollection(
                collectionId = "[COLLECTION_ID]",
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
suspend fun deletecollectionTest(database: Database) {
    try {
        val response = database.deleteCollection(
                collectionId = "[COLLECTION_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun listdocumentsTest(database: Database) {
    try {
        val response = database.listDocuments(
                collectionId = "[COLLECTION_ID]",
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createdocumentTest(database: Database) {
    try {
        val response = database.createDocument(
                collectionId = "[COLLECTION_ID]",
                data = mapOf( "a" to "b" ),
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getdocumentTest(database: Database) {
    try {
        val response = database.getDocument(
                collectionId = "[COLLECTION_ID]",
                documentId = "[DOCUMENT_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updatedocumentTest(database: Database) {
    try {
        val response = database.updateDocument(
                collectionId = "[COLLECTION_ID]",
                documentId = "[DOCUMENT_ID]",
                data = mapOf( "a" to "b" ),
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun deletedocumentTest(database: Database) {
    try {
        val response = database.deleteDocument(
                collectionId = "[COLLECTION_ID]",
                documentId = "[DOCUMENT_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}








