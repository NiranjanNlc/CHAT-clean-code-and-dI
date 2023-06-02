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
import androidx.test.filters.LargeTest
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.CoreMatchers.any
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.FragmentLoginBinding
import org.lniranjan.chatclone.modal.Credentials
import org.lniranjan.chatclone.ui.fragment.LoginFragment
import org.lniranjan.chatclone.ui.fragment.launchFragmentInHiltContainer
import org.lniranjan.chatclone.ui.viewmodel.AuthViewModel

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginFragmentTest {

     var authViewModel: AuthViewModel = mockk()

    lateinit var binding : FragmentLoginBinding

    @Before
    fun setup() {
        // Launch the fragment
        launchFragmentInHiltContainer<LoginFragment>{
            binding = this.bindind
            authViewModel = this.viewModel
        }


    }
    @Test
    fun checkIfLoginLayoutVissible()
    {
        // Check if the login layout is visible
        Espresso.onView(ViewMatchers.withId(binding.logInLayout.id))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
    @Test
    fun checkIfSighnupayoutVissible()
    {
        Espresso.onView(ViewMatchers.withId(binding.signUp.id))
            .perform(ViewActions.click())
//         Check if the login layout is visible
        Espresso.onView(ViewMatchers.withId(binding.signUpLayout.id))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
//    @Test
//    fun testLoginFragmentIsConnectedWithViewModal() {
//        // Enter text in the email field
//        Espresso.onView(ViewMatchers.withId(binding.eMail.id))
//            .perform(ViewActions.typeText("example@example.com"))
//            .perform(ViewActions.closeSoftKeyboard())
//
//
//        // Enter text in the password field
//        Espresso.onView(ViewMatchers.withId(binding.passwords.id))
//            .perform(ViewActions.typeText("password"))
//            .perform(ViewActions.closeSoftKeyboard())
//        Thread.sleep(1000   )
//        // Perform click on the submit button
//        Espresso.onView(ViewMatchers.withId(binding.submit.id))
//            .perform(ViewActions.click())
//        Thread.sleep(1000   )
//        // Verify that the login function is called in the view model
//        verify{authViewModel.login(any())}
//    }

//    @Test(timeout = 5000 )
//    fun socialMediaAreNotImplemented()
//    {
//        Espresso.onView(ViewMatchers.withId(binding.facebookLogo.id))
//            .perform(ViewActions.click())
////        Thread.sleep(1000   )
//        // Check if the toast message is displayed
//        onView(withText(containsString("NIY")))
//            .inRoot(isPlatformPopup())
//            .check(matches(isDisplayed()))
//    }
}
