package org.lniranjan.chatclone.ui.fragment

import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lniranjan.chatclone.databinding.FragmentLoginBinding
import org.lniranjan.chatclone.R

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFragmentTest
{

    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController
    @Before
    fun setUp()
    {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
//        navController.setGraph(R.navigation.nav_graph)
        // mock the view model and its result

    }

    @Test
    fun displayBioFragmentOnRegisteringWIthEmailAndPassword()
    {
        onView(withId(binding.eMails.id)).perform(typeText("real@user.com"));
        onView(withId(binding.passwords01.id)).perform(typeText("secret"));
        onView(withId(binding.passwordss.id)).perform(typeText("secret"));
        onView(withId(binding.submit.id)).perform(click());
        navController.currentDestination?.id?.let { assert(it.equals(R.id.settingFragment)) }
    }

}