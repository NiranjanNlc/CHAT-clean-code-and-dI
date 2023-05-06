package org.lniranjan.data_appwrite

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import io.appwrite.Client
import org.junit.Before
import org.junit.Test
import org.mockito.MockedConstruction


class Initiate {

    private lateinit var appContext: Context

    @Before
    @Throws(Exception::class)
    fun setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext()
    }
    @Test
    fun initiate() {
        val client = Client(appContext)
            .setEndpoint(PROJECT.endpoint)
            .setProject(PROJECT.projectId)
            .setSelfSigned(true)
    // For self signed certificates, only use for development
   }
}