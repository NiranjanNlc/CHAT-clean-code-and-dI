package org.lniranjan.chatclone.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.lniranjan.chatclone.databinding.ChatItemBinding
import org.lniranjan.chatclone.databinding.ContactItemBinding
import org.lniranjan.chatclone.modal.ProfileDetail

class ContactListAdapter: ListAdapter<ProfileDetail,ContactListAdapter.ContactListViewHolder>(ProfileDetailDiffCallback) {

    companion object ProfileDetailDiffCallback : DiffUtil.ItemCallback<ProfileDetail>()
    {
        override fun areItemsTheSame(oldItem: ProfileDetail, newItem: ProfileDetail): Boolean
        {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ProfileDetail, newItem: ProfileDetail): Boolean {
            return oldItem.equals(newItem)
        }
    }
    class ContactListViewHolder(var items:  ContactItemBinding ): RecyclerView.ViewHolder(items.root) {
        fun bind(contactItem : ProfileDetail) {
            items.user = contactItem
        }
        companion object {
            fun from(parent: ViewGroup): ContactListViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ContactItemBinding.inflate(inflater)
                return ContactListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        return ContactListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        val chatItem = getItem(position)
        holder.bind(chatItem)
        holder.items.executePendingBindings()
    }
}