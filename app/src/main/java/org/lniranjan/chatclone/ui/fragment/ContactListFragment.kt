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
import org.lniranjan.chatclone.databinding.FragmentContactListBinding
import org.lniranjan.chatclone.ui.adapter.ChatListAdapter
import org.lniranjan.chatclone.ui.adapter.ContactListAdapter
import org.lniranjan.chatclone.ui.viewmodel.ContactViewModel


@AndroidEntryPoint
class ContactListFragment : Fragment() {

    private lateinit var adapter: ContactListAdapter
    private lateinit var binding: FragmentContactListBinding
    private val viewModel by viewModels<ContactViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_contact_list, container, false)
        setAdapter()
        setObsever()
        return binding.root}
    private fun setObsever() {
        viewModel.contactList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun setAdapter() {
        adapter = ContactListAdapter()
        binding.contactList.adapter = adapter
    }
}