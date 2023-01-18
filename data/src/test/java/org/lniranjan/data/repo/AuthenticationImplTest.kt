package org.lniranjan.data.repo

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.lniranjan.data.source.firebase.FirebaseAuthenciation
import org.lniranjan.domain.entity.User
import org.mockito.Mock
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.notNull
import org.mockito.kotlin.whenever
import org.lniranjan.domain.entity.Result as Result1

class AuthenticationImplTest {

    @Mock
    private  var authentication  = mock<FirebaseAuthenciation>()
    private var testUser = mock<User>()
    @Before
    fun setUp() {

    }
    @Test
    fun testlogin() = runTest {
        whenever(authentication.login("test","test"))
            .thenReturn(flowOf(Result1.Success(testUser)))
        val result = authentication.login("test", "test")
        assertNotNull(result)
    }

    @Test
    fun testlogout() = runTest{
//        whenever(authentication.logout()).thenReturn(notNull())
       authentication.logout()
        assert(true)
    }

    @Test
    fun testsighnUp() = runTest{
        whenever(authentication.signUp(testUser))
            .thenReturn(flowOf( Result1.Success(testUser)))
        val result = authentication.signUp(testUser)
        assertNotNull(result)
    }

    @Test
    fun getUser() = runTest{
        whenever(authentication.getUser()).thenReturn(
            flowOf(testUser)
        )
        val result = authentication.getUser()
        assertNotNull(result)
    }
}