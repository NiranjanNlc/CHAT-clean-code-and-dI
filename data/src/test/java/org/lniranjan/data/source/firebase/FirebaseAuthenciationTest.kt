package org.lniranjan.data.source.firebase

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lniranjan.domain.entity.User
import org.mockito.ArgumentMatchers.anyString
import org.mockito.ArgumentMatchers.notNull
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock

@RunWith(MockitoJUnitRunner.Silent::class)
class FirebaseAuthenciationTest {

    @Mock
    private var  firebaseauth = mock<FirebaseAuth>()

    private  var authenciation = mock<FirebaseAuthenciation>()
    private val mail = "niranja8n@gmail.com"
    private val password = "fuvkyou"
    private lateinit var user: User

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
     fun setUp() {
        user = User(mail, password)
     }

    @Test
    fun testSighnUpFunction()
    {

        Mockito.`when`(mock<FirebaseAuth>().createUserWithEmailAndPassword(anyString(), anyString()))
            .thenReturn(notNull())
        assert( authenciation.sighnUp(user) == null)
    }
    @Test
    fun testSighnInFunction()
    {
        Mockito.`when`(mock<FirebaseAuth>().signInWithEmailAndPassword(anyString(),anyString())).thenReturn(notNull(), notNull())
        assert( authenciation.login(user.mail, user.password) == null)
    }

    @Test
    fun testLogOutFunction()
    {
        Mockito.doNothing().`when`(mock<FirebaseAuth>()).signOut() // doNothing().`when`(mock<FirebaseAuth>().signOut())
        assert( authenciation.logout() == null)
    }

    @Test
    fun testGetUserFunction()
    {
        Mockito.`when`(mock<FirebaseAuth>().currentUser).thenReturn(mock())
        assert( authenciation.getUser() ==  null)
    }



}