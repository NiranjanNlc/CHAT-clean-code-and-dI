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

/*
* User need toenter the user details 
* if correct then the return required values 
* */
class LoginTest {

    private val authenciation = mock<Authenciation>()
    private val correctUser =User(mail = "nlc@gmail.com")
    private val useCase = Login(mock(),authenciation)
    private   val userWithIncorrectCredentials :User = correctUser.copy(mail = "jpt@gmail.com" , password = "djdkfakf")
    private   val userWithIncorrectPassword :User=correctUser.copy(password = "jpt@gmail.com" )
    private   val userWithIncorrectEmail :User=correctUser.copy(mail = "jpt@gmail.com" )
    private   lateinit var request: Login.Request

    @ExperimentalCoroutinesApi
    @Before
    fun setUp()
    {
//        print(correctUser)
        print(" check dude ${userWithIncorrectCredentials.mail} and ${userWithIncorrectCredentials.password}")
        whenever(authenciation.login(userWithIncorrectCredentials.mail, userWithIncorrectCredentials.password)).thenReturn(flowOf(false))
        whenever(authenciation.login(userWithIncorrectEmail.mail, userWithIncorrectEmail.password)).thenReturn(flowOf(false))
        whenever(authenciation.login(userWithIncorrectPassword.mail, userWithIncorrectPassword.password)).thenReturn(flowOf(false))
        whenever(authenciation.login(correctUser.mail, correctUser.password)).thenReturn(flowOf(true))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithIncorrectCredentials() =runBlockingTest {
        request = Login.Request(userWithIncorrectCredentials.mail, userWithIncorrectCredentials.password)
        val response= useCase.process(request)
        Assert.assertEquals(Login.Response(false), response.first())
    }
    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithIncorrectIncorrectEmail() = runBlockingTest {
        request = Login.Request(userWithIncorrectEmail.mail, userWithIncorrectEmail.password)
        val response= useCase.process(request)
        Assert.assertEquals(Login.Response(false), response.first()) 

    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithIncorrectIncorrectPassword() = runBlockingTest {
        request = Login.Request(userWithIncorrectPassword.mail, userWithIncorrectPassword.password)
        val response= useCase.process(request)
        Assert.assertEquals(Login.Response(false), response.first()) 
    }
    @ExperimentalCoroutinesApi
    @Test
    fun testExampleWithCorrectCredintials() = runBlockingTest {
        request = Login.Request( correctUser.mail,  correctUser.password)
        val response= useCase.process(request)
        Assert.assertEquals(Login.Response(true), response.first()) 
    }
}