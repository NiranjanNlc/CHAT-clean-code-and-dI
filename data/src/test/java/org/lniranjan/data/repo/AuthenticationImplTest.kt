package org.lniranjan.data.repo

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

class AuthenticationImplTest {

    @Mock
    private  var authentication  = mock<FirebaseAuthenciation>()
    @Before
    fun setUp() {

    }
    @Test
    fun testlogin() {
        whenever(authentication.login(any(), any())).thenReturn(notNull(), notNull())
        val result = authentication.login("test", "test")
        assertNotNull(result)
    }

    @Test
    fun testlogout() {
//        whenever(authentication.logout()).thenReturn(notNull())
       authentication.logout()
        assert(true)
    }

    @Test
    fun testsighnUp() {
        whenever(authentication.sighnUp(any())).thenReturn(notNull())
        val result = authentication.sighnUp(User("test", "test"))
        assertNotNull(result)
    }

    @Test
    fun getUser() {
//        whenever(authentication.getUser()).thenReturn(notNull(), notNull())
        val result = authentication.getUser()
        assertNotNull(result)
    }
}