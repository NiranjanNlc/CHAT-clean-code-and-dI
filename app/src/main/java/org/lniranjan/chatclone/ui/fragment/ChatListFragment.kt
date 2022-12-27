package org.lniranjan.chatclone.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.FragmentChatListBinding
import org.lniranjan.chatclone.ui.adapter.ChatListAdapter
import org.lniranjan.chatclone.ui.viewmodel.ChatViewModel


@AndroidEntryPoint
class ChatListFragment : Fragment() {

    private lateinit var binding: FragmentChatListBinding
    private val viewModel by viewModels<ChatViewModel>()
    private lateinit var adapter: ChatListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_chat_list, container, false)
        setAdapter()
        setObsever()
        return binding.root
    }

    private fun setObsever() {
        viewModel.chatList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun setAdapter() {
        adapter = ChatListAdapter()
        binding.chatList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

    }
}