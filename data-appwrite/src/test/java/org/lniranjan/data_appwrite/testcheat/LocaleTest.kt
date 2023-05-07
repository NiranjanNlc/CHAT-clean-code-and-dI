package io.appwrite.servicesTest

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import io.appwrite.Client
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Locale


suspend fun main() {
    val client = Client()
        .setProject("[YOUR_PROJECT_ID]")
        .setEndpoint("[YOUR_ENDPOINT]")
        .setKey("[YOUR_KEY]")

    val locale = Locale(client)

    getTest(locale)
    getcontinentsTest(locale)
    getcountriesTest(locale)
    getcountrieseuTest(locale)
    getcountriesphonesTest(locale)
    getcurrenciesTest(locale)
    getlanguagesTest(locale)

}

suspend fun getTest(locale: Locale) {
    try {
        val response = locale.get()
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getcontinentsTest(locale: Locale) {
    try {
        val response = locale.getContinents()
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getcountriesTest(locale: Locale) {
    try {
        val response = locale.getCountries()
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getcountrieseuTest(locale: Locale) {
    try {
        val response = locale.getCountriesEU()
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getcountriesphonesTest(locale: Locale) {
    try {
        val response = locale.getCountriesPhones()
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getcurrenciesTest(locale: Locale) {
    try {
        val response = locale.getCurrencies()
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}
suspend fun getlanguagesTest(locale: Locale) {
    try {
        val response = locale.getLanguages()
        var jsonString = response.body?.string() ?: ""
        val gson = GsonBuilder().setPrettyPrinting().create()
        val je: JsonElement = JsonParser().parse(jsonString)
        println(gson.toJson(je))
    } catch (e: AppwriteException) {
        println(e)
    }
}








