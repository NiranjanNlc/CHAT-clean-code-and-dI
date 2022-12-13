package org.lniranjan.chatclone.ui.fragment

import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lniranjan.chatclone.R

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFragmentTest
{

    private lateinit var navController: NavController
    @Before
    fun setUp()
    {


    }

    @Test
    fun testLaunchOfFragment()
    {
        launchFragmentInHiltContainer<LoginFragment> {  }
    }

    @Test
    fun displayBioFragmentOnRegisteringWIthEmailAndPassword()
    {
        onView(withId(R.id.eMails)).perform(typeText("real@user.com"));
        onView(withId(R.id.passwords01)).perform(typeText("secret"));
        onView(withId(R.id.passwordss)).perform(typeText("secret"));
        onView(withId(R.id.submit)).perform(click());
        navController.currentDestination?.id?.let { assert(it.equals(R.id.chatListFragment)) }
    }

}