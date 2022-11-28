package org.lniranjan.domain.usecases.auth

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.lniranjan.domain.entity.User
import org.lniranjan.domain.repo.Authenciation 
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

/* SIGHN UP
* gets the necessary details from the user
*  Write user to the dtabase with alll details
*  Preserve the mail , password and user id with the firebase .....
* */
 class SignUpTest {

    private val authenciation = mock<Authenciation>()
    private val correctUser = User(mail = "nlc@gmail.com")
    private val useCase = SignUpUseCase(mock(),authenciation)
    private   val userWithIncorrectCredentials : User = correctUser.copy(mail = "jpt@gmail.com" , password = "djdkfakf")
    private   val userWithIncorrectPassword : User =correctUser.copy(password = "jpt@gmail.com" )
    private   val userWithIncorrectEmail : User =correctUser.copy(mail = "jpt@gmail.com" )
    private   lateinit var request: SignUpUseCase.Request

    @ExperimentalCoroutinesApi
    @Before
     fun setUp() = runBlockingTest{
//        print(correctUser)
        print(" check dude ${userWithIncorrectCredentials.mail} and ${userWithIncorrectCredentials.password}")
        whenever(authenciation.login(userWithIncorrectCredentials.mail, userWithIncorrectCredentials.password)).thenReturn(
            flowOf(false)
        )
        whenever(authenciation.login(userWithIncorrectEmail.mail, userWithIncorrectEmail.password)).thenReturn(
            flowOf(false)
        )
        whenever(authenciation.login(userWithIncorrectPassword.mail, userWithIncorrectPassword.password)).thenReturn(
            flowOf(false)
        )
        whenever(authenciation.login(correctUser.mail, correctUser.password)).thenReturn(flowOf(true))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithIncorrectCredentials() = runBlockingTest {
        request = SignUpUseCase.Request(userWithIncorrectCredentials )
        val response= useCase.process(request)
        Assert.assertEquals(SignUpUseCase.Response(correctUser), response.first())
    }
    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithIncorrectIncorrectEmail() = runBlockingTest {
        request = SignUpUseCase.Request(userWithIncorrectEmail )
        val response= useCase.process(request)
        Assert.assertEquals(SignUpUseCase.Response(correctUser), response.first())

    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithIncorrectIncorrectPassword() = runBlockingTest {
        request = SignUpUseCase.Request(userWithIncorrectPassword )
        val response= useCase.process(request)
        Assert.assertEquals(SignUpUseCase.Response(correctUser), response.first())
    }
    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithCorrectCredintials() = runBlockingTest {
        request = SignUpUseCase.Request( correctUser)
        val response= useCase.process(request)
        Assert.assertEquals(SignUpUseCase.Response(correctUser), response.first())
    }

}