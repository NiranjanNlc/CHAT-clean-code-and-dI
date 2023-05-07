package io.appwrite.servicesTest

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import io.appwrite.Client
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Storage
import okio.BufferedSink
import okio.Okio
import okio.buffer
import okio.sink
import java.io.File


suspend fun main() {
    val client = Client()
        .setProject("[YOUR_PROJECT_ID]")
        .setEndpoint("[YOUR_ENDPOINT]")
        .setKey("[YOUR_KEY]")

    val storage = Storage(client)

    listfilesTest(storage)
    createfileTest(storage)
    getfileTest(storage)
    updatefileTest(storage)
    deletefileTest(storage)
    getfiledownloadTest(storage)
    getfilepreviewTest(storage)
    getfileviewTest(storage)

}

suspend fun listfilesTest(storage: Storage) {
    try {
        val response = storage.listFiles(
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun createfileTest(storage: Storage) {
    try {
        val response = storage.createFile(
                file = File("./path-to-files/image.jpg"),
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getfileTest(storage: Storage) {
    try {
        val response = storage.getFile(
                fileId = "60cb5cb160812"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun updatefileTest(storage: Storage) {
    try {
        val response = storage.updateFile(
                fileId = "60cb5cb160812",
                read = listOf("*"),
                write = listOf("*")
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun deletefileTest(storage: Storage) {
    try {
        val response = storage.deleteFile(
                fileId = "[FILE_ID]"
        )
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getfiledownloadTest(storage: Storage) {
    try {
        val response = storage.getFileDownload(
                fileId = "60cb5cb160812"
        )
        val downloadedFile: File = File("download.png")
        val sink: BufferedSink = downloadedFile.sink().buffer()
        sink.writeAll(response.body!!.source())
        sink.close()
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getfilepreviewTest(storage: Storage) {
    try {
        val response = storage.getFilePreview(
                fileId = "60cb5cb160812",
        )
        val downloadedFile: File = File("download.png")
        val sink: BufferedSink = downloadedFile.sink().buffer()
        sink.writeAll(response.body!!.source())
        sink.close()
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getfileviewTest(storage: Storage) {
    try {
        val response = storage.getFileView(
                fileId = "60cb5cb160812"
        )
        val downloadedFile: File = File("download.png")
        val sink: BufferedSink = downloadedFile.sink().buffer()
        sink.writeAll(response.body!!.source())
        sink.close()
    } catch (e: AppwriteException) {
        println(e)
    }
}








