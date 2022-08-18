package org.lniranjan.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.lniranjan.domain.entity.UseCaseException
import org.lniranjan.domain.usecases.UseCase
import org.mockito.kotlin.mock
import java.util.*

class UseCaseTest {

    @ExperimentalCoroutinesApi
    private val configuration = UseCase.Configuration(TestCoroutineDispatcher())
    private val request = mock<UseCase.Request>()
    private val response = mock<UseCase.Response>()
    @ExperimentalCoroutinesApi
    private lateinit var useCase: UseCase<UseCase.Request, UseCase.Response>

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        useCase = object : UseCase<UseCase.Request, UseCase.Response>(configuration) {
            override fun process(request: Request): Flow<Response> {
                assertEquals(this@UseCaseTest.request, request)
                return flowOf(response)
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExecuteSuccess() = runBlockingTest {
        val result = useCase.execute(request).first()
        println("result $result   for $response ")
        assertEquals(Result.success(response), result)
    }
    @ExperimentalCoroutinesApi
    @Test
    fun testExecuteException() {
        useCase = object : UseCase<UseCase.Request, UseCase.Response>(configuration) {
            override fun process(request: Request): Flow<Response> {
                assertEquals(this@UseCaseTest.request, request)
                return flow {
                    throw UseCaseException.ChatException(Throwable())
                }
            }

        }
        runBlockingTest {
            val result = useCase.execute(request).first()
            assertTrue((result.isFailure))
        }
    }
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}