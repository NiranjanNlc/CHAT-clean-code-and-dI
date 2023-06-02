import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.modal.Credentials
import org.lniranjan.chatclone.ui.fragment.LoginFragment
import org.lniranjan.chatclone.ui.fragment.launchFragmentInHiltContainer
import org.lniranjan.chatclone.ui.viewmodel.AuthViewModel
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Mock
    private lateinit var authViewModel: AuthViewModel

    @Before
    fun setup() {
        // Launch the fragment
        launchFragmentInHiltContainer<LoginFragment> {

        }
    }

    @Test
    fun checkIfLoginLayoutVissible()
    {
        // Check if the login layout is visible
        Espresso.onView(ViewMatchers.withId(R.id.logInLayout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
    @Test
    fun testLoginFragmentIsConnectedWithViewModal() {
        // Enter text in the email field
        Espresso.onView(ViewMatchers.withId(R.id.eMail))
            .perform(ViewActions.typeText("example@example.com"))

        // Enter text in the password field
        Espresso.onView(ViewMatchers.withId(R.id.passwords))
            .perform(ViewActions.typeText("password"))

        // Perform click on the submit button
        Espresso.onView(ViewMatchers.withId(R.id.submit))
            .perform(ViewActions.click())

        // Verify that the login function is called in the view model
        verify(authViewModel).login(any())
    }

    @Test
    fun socialMediaAreNotImplemented()
    {
        Espresso.onView(ViewMatchers.withId(R.id.facebookLogo))
            .perform(ViewActions.click())
        // Check if the toast message is displayed
        onView(withText("Not implemented yet"))
            .inRoot(isPlatformPopup())
            .check(matches(isDisplayed()))
    }
}
