package org.lniranjan.data.source.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lniranjan.domain.entity.User
import org.mockito.ArgumentMatchers.anyString
import org.mockito.ArgumentMatchers.notNull
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.lang.Exception
import java.util.concurrent.Executor
import org.lniranjan.domain.entity.Result as Result1

@RunWith(MockitoJUnitRunner.Silent::class)
class FirebaseAuthenciationTest {
    @Mock
    private lateinit var successTask: Task<AuthResult>
    private lateinit var failureTask: Task<AuthResult>

    @Mock
    private var firebaseauth = mock<FirebaseAuth>()

    @Mock
    private var firebaseUser = mock<FirebaseUser>()

    @Mock
    private lateinit var authenciation: FirebaseAuthenciation
    private val mail = "niranja8n@gmail.com"
    private val password = "fuvkyou"
    private lateinit var user: User


    @Test
    fun testSighnInFunction() = runTest(UnconfinedTestDispatcher()) {
        println(" i am in this function ")
        println("Lets launch this ")
        val job = launch {
            assert(authenciation.login(user.mail, user.password).first() == Result1.Success(user))
        }
        job.cancel()
        println("end ..............")
        }

    @Test
    fun testSighnUpFunction() = runTest {
        Mockito.`when`(
            firebaseauth.createUserWithEmailAndPassword(mail,password))
            .thenReturn(successTask)
        val job = launch {
            assert(authenciation.signUp(user).first() == Result1.Success(user))
        }
        job.cancel()
        }

    @Test
    fun testLogOutFunction() = runTest {
        Mockito.doNothing().`when`(firebaseauth)
            .signOut() // doNothing().`when`(firebaseauth.signOut())
        assert(authenciation.logout().first() == true)
    }

    @Test
    fun testGetUserFunction() = runTest {
        Mockito.`when`(firebaseauth.currentUser).thenReturn(firebaseUser)
        Mockito.`when`(firebaseUser.email).thenReturn(mail)
        Mockito.`when`(firebaseUser.uid).thenReturn("3333")
        val job =  launch {
            assert(authenciation.getUser().first().mail == mail)
        }
        job.cancel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        authenciation = FirebaseAuthenciation(firebaseauth)
        user = User(mail, password)
        successTask = mock()
        Mockito.`when`(firebaseauth.signInWithEmailAndPassword(mail, password))
            .thenReturn(successTask)
        val mockAuth = mock<FirebaseAuth>()
        whenever(mockAuth.signInWithEmailAndPassword(mail, password))
            .doReturn(successTask)
//        Mockito.`when`(successTask.await().user)
//            .thenReturn(firebaseUser)
//        Mockito.`when`(firebaseUser.email)
//            .thenReturn(user.mail)

    }
}