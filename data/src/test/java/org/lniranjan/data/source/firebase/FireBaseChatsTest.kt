package org.lniranjan.data.source.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.lniranjan.domain.entity.Chat
import org.lniranjan.domain.entity.User
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class FireBaseChatsTest {

    private lateinit var firebaseChats: FireBaseChats
    private lateinit var mockRootRef: DatabaseReference
    private lateinit var mockchatRef: DatabaseReference
    private lateinit var taskSnapshotmock : Task<DataSnapshot>
    private lateinit var mockDataSnapshot: DataSnapshot
    private lateinit var mockUserReference: DatabaseReference
    private lateinit var mockChat: Chat
    private val testUserId = "testUserId"

    @Before
    fun setUp() {
        mockRootRef = mock()
        firebaseChats = FireBaseChats(mockRootRef)
        taskSnapshotmock = mock()
        mockchatRef = mock()
        mockUserReference = mock()
        mockDataSnapshot = mock()
    }
    @Test
    fun `test getListOfChats`() = runTest {
        val chat = Chat(1L, User("testUserId1", "testUserName1", "testUserEmail1"), "testMessage1")
        val chat1 = Chat( 1L, User("testUserId1", "testUserName1", "testUserEmail1"), "testMessage1")
        val chat2 = Chat( 2L, User("testUserId2", "testUserName2", "testUserEmail2"), "testMessage2")
        val chatList = listOf(chat,chat1,chat2)
        val chatPATH = "chats/$testUserId"
        Mockito.`when`(mockRootRef.child(chatPATH)).thenReturn(mockchatRef)
        Mockito.`when`(mockchatRef.get()).thenReturn(taskSnapshotmock)
        Mockito.`when`(taskSnapshotmock.result).thenReturn(mockDataSnapshot)
        Mockito.`when`(mockDataSnapshot.getValue()).thenReturn(chatList)
        val job = launch {
            val result = firebaseChats.getListOfChats("testUserId")
            assertEquals(chatList, result)
        }
        job.cancel()
        }

    @Test
    fun `test getListOfUser`() = runTest {
        val uid = "testUserId"
        val user1 = User("user1", "testName1")
        val user2 = User("user2", "testName2")
        val user3 = User("testUserId", "testName3")
        val userList = listOf(user1, user2, user3)

        val mockDataSnapshot = mock<DataSnapshot>()
        val mockChildren = userList.map { mock<DataSnapshot>() }
        whenever(mockRootRef.child("users")).thenReturn(mockUserReference)
        whenever(mockUserReference.get()).thenReturn(taskSnapshotmock)
        whenever(taskSnapshotmock.result).thenReturn(mockDataSnapshot)
        whenever(mockDataSnapshot.children).thenReturn(mockChildren)
        val job = launch {
            val result = firebaseChats.getListOfUser(uid)
            assertEquals(userList.filter { it.userId != uid }, result)
        }
        job.cancel()
    }
}
