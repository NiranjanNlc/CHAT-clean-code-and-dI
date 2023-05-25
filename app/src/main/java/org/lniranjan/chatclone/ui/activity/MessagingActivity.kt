package org.lniranjan.chatclone.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.ActivityMessagingBinding
import org.lniranjan.chatclone.modal.MessageItem
import org.lniranjan.chatclone.ui.adapter.MessageAdapter
import org.lniranjan.chatclone.ui.viewmodel.MessageViewModel

@AndroidEntryPoint
class MessagingActivity : AppCompatActivity() {

    lateinit var binding: ActivityMessagingBinding
    val viewModal: MessageViewModel by viewModels()
    lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_messaging)
        binding.lifecycleOwner = this
        // Initialize your view model here direct from the dependancy injection
        adapter = MessageAdapter() // Initialize your adapter here
        binding.recyclerGchat.adapter = adapter
        binding.recyclerGchat.layoutManager = LinearLayoutManager(this)

        binding.buttonSend.setOnClickListener {
            val message = binding.editMessage.text.toString()
            if (message.isNotBlank()) {
                viewModal.sendMessage(MessageItem(message = message))
                binding.editMessage.text?.clear()
                binding.editMessage.clearFocus()
            }
        }
        // Observe the message list in the view model
        viewModal.messageList.observe(this) { it ->
            adapter.submitList(it)
            if (it.size!=0) binding.recyclerGchat.smoothScrollToPosition(it.size - 1)
        }
    }
}