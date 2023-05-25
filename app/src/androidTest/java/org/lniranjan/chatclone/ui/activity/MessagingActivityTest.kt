package org.lniranjan.chatclone.ui.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.lniranjan.chatclone.databinding.ActivityMessagingBinding
import org.lniranjan.chatclone.modal.MessageItem
import org.lniranjan.chatclone.ui.viewmodel.MessageViewModel

@RunWith(AndroidJUnit4::class)
class MessagingActivityTest {

    @Rule
    @JvmField
    val activityRule: ActivityScenarioRule<MessagingActivity> =
        ActivityScenarioRule(MessagingActivity::class.java)
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMessagingBinding
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var viewModel: MessageViewModel
    private lateinit var testMessages: MutableList<MessageItem>

    @Before
    fun setUp() {
        activityRule.scenario.onActivity {
            binding = it.binding
            recyclerView = it.binding.recyclerGchat
            adapter = it.binding.recyclerGchat.adapter!!
            viewModel = it.viewModal
        }
    }

        @Test
        fun testRecyclerViewExists() {
            // Check if the RecyclerView exists
            Espresso.onView(withId(binding.recyclerGchat.id))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }

        @Test
        fun testSendMessage() {
            val message = "Hello, World!" // MessageItem to be sent
            // Type the message into the TextInputEditText
            Espresso.onView(withId(binding.editMessage.id)).perform(ViewActions.typeText(message))
            Espresso.closeSoftKeyboard()
            // Click the send button
            Espresso.onView(withId(binding.buttonSend.id)).perform(ViewActions.click())
            // Check if the message is displayed in the RecyclerView
            Espresso.onView(ViewMatchers.withId(recyclerView.id)).check(
                ViewAssertions.matches(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withText(message)
                    )
                )
            )
            assert(true)
        }

        @Test
        fun testRecyclerViewItemCount() {
            testMessages = mutableListOf(
                MessageItem(message = "MessageItem 1"),
                MessageItem(message = "MessageItem 2"),
                MessageItem(message = "MessageItem 3")
            )
            viewModel._messageList.postValue(testMessages)
            // Check if the RecyclerView displays the expected number of items
            Thread.sleep(1000)
            Assert.assertEquals(
                "RecyclerView item count should match the test dataset size",
                testMessages.size,
                adapter?.itemCount
            )
        }

        @Test
        fun testRecyclerViewDataPopulation() {
            testMessages = mutableListOf(
                MessageItem(message = "MessageItem 1"),
                MessageItem(message = "MessageItem 2"),
                MessageItem(message = "MessageItem 3")
            )
            viewModel._messageList.postValue(testMessages)
            Thread.sleep(1000)
            // Check if the RecyclerView displays the correct data
            Espresso.onView(withId(binding.recyclerGchat.id))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("MessageItem 1"))))
            Espresso.onView(withId(binding.recyclerGchat.id))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("MessageItem 2"))))
            Espresso.onView(withId(binding.recyclerGchat.id))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("MessageItem 3"))))

        }

        @Test
        fun testRecyclerViewEmptyState() {
            // Set up an empty dataset in the ViewModel
            viewModel.deleteAllMessages()
            // Check if the RecyclerView displays an empty state UI
            Assert.assertEquals(
                "RecyclerView should show an empty state UI when the dataset is empty",
                0,
                adapter?.itemCount
            )
            // ... Add assertions to check if the empty state UI is correctly displayed
        }

        @Test
        fun testRecyclerViewItemRemoval() {
            testMessages = mutableListOf(
                MessageItem(message = "MessageItem 1"),
                MessageItem(message = "MessageItem 2"),
                MessageItem(message = "MessageItem 3")
            )
            // Wait for the data to be updated
            Thread.sleep(1000)
            // Remove an item from the dataset
            val position = 0
            testMessages.removeAt(position)
            viewModel._messageList.postValue(testMessages)

            // Wait for the data to be updated
            Thread.sleep(1000)

            // Check if the RecyclerView updates correctly after item removal
            Espresso.onView(withId(binding.recyclerGchat.id))
                .check(
                    ViewAssertions.matches(
                        CoreMatchers.not(
                            ViewMatchers.hasDescendant(
                                ViewMatchers.withText("MessageItem 1")
                            )
                        )
                    )
                )
            Espresso.onView(withId(binding.recyclerGchat.id))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("MessageItem 2"))))
            Espresso.onView(withId(binding.recyclerGchat.id))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("MessageItem 3"))))
            Assert.assertEquals(testMessages.size, adapter.itemCount)
        }

        @Test
        fun testRecyclerViewItemClickListener() {

            // future enhancement
            assert(true)
        }
    }
