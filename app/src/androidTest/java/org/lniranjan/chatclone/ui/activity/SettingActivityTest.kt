package org.lniranjan.chatclone.ui.activity

import android.content.Context
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnitRunner
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.lniranjan.chatclone.databinding.ActivitySettingBinding
import org.lniranjan.chatclone.ui.viewmodel.SettingViewModel

@RunWith(AndroidJUnit4::class)
class SettingActivityTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(SettingActivity::class.java)

    private lateinit var binding: ActivitySettingBinding
    private lateinit var viewModel: SettingViewModel

    private lateinit var activity: SettingActivity

    @Before
    fun setUp() {
        // Use the 'testing' Context
        activityRule.scenario.onActivity {
            binding = it.binding
//            viewModel = it.viewModel
            activity = it
        }
    }

    @Test
    fun checkSum() {
        val expected = 4
        val actual = 2 + 2
        assertEquals(expected, actual)
    }
    @Test
    fun testEditTextFieldsDisplayed() {
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testEditTextFieldsEditableOnEditMode() {
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    }

    @Test
    fun testEditTextFieldsNonEditableOnNonEditMode() {
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.isNotEnabled()))
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.isNotEnabled()))
    }

    @Test
    fun testSaveButtonDisplayedOnEditMode() {
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .check(ViewAssertions.matches(ViewMatchers.withText("Save Profile")))
    }

    @Test
    fun testUpdateButtonDisplayedOnNonEditMode() {
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .check(ViewAssertions.matches(ViewMatchers.withText("Edit Profile")))
    }
    @Test
    fun testUserNameEditTextContent() {
        // Click the Update button
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Thread.sleep(1000)
        val testUserName = "John Doe"
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .perform(ViewActions.typeText(testUserName), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUserName)))
    }

    @Test
    fun testBioEditTextContent() {

        // Click the Update button
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Thread.sleep(1000)
        val testBio = "I love coding!"
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .perform(ViewActions.typeText(testBio), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.withText(testBio)))
    }

    @Test
    fun testUpdateButtonClicked() {
        val testUserName = "John Doe"
        val testBio = "I love coding!"

        // Click the Update button
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Thread.sleep(1000)
        // Verify that the EditText fields are editable
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
        // Enter values in EditText fields
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .perform(ViewActions.typeText(testUserName), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .perform(ViewActions.typeText(testBio), ViewActions.closeSoftKeyboard())
        // Verify that the values are saved
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUserName)))
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.withText(testBio)))
    }

    @Test
    fun testEditModeToggle() {
//
        // Enter edit mode
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Thread.sleep(1000)
        // Verify that EditText fields are enabled
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.isEnabled()))

        // Exit edit mode
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Thread.sleep(1000)
        // Verify that EditText fields are disabled
        Espresso.onView(ViewMatchers.withId(binding.setUserName.id))
            .check(ViewAssertions.matches(ViewMatchers.isNotEnabled()))
        Espresso.onView(ViewMatchers.withId(binding.setBio.id))
            .check(ViewAssertions.matches(ViewMatchers.isNotEnabled()))
    }

    @Test
    fun testSaveButtonClicked() {

        // Enter edit mode
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())

        // Click the Save button
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .perform(ViewActions.click())
        Thread.sleep(1000)
        // Verify that the button text changes to "Update"
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .check(ViewAssertions.matches(ViewMatchers.withText("Edit Profile")))
    }

    @Test
    fun testUpdateButtonDisplayedOnStartup() {
        // Verify that the button text is "Update" on startup
        Espresso.onView(ViewMatchers.withId(binding.updateSettingsBtn.id))
            .check(ViewAssertions.matches(ViewMatchers.withText("Edit Profile")))
    }
}
