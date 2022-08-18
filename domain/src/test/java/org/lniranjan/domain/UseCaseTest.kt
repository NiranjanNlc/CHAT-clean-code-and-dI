package org.lniranjan.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Test

import org.junit.Assert.*
import org.lniranjan.domain.usecases.UseCase

class UseCaseTest {

    @ExperimentalCoroutinesApi
    private val configuration = UseCase.Configuration(TestCoroutineDispatcher())
    private val request = mock<UseCase.Request>()
    private val response = mock<UseCase.Response>()
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}