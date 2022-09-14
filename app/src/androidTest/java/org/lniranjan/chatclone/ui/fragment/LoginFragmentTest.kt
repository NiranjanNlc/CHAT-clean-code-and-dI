package org.lniranjan.chatclone.ui.fragment

import org.junit.Assert.assertEquals
import org.junit.Test

internal class LoginFragmentTest
{
    @Test
    fun testLogin()
    {
        val loginFragment = LoginFragment()
        val result = loginFragment.submit()
        assertEquals(true, result)
    }
}