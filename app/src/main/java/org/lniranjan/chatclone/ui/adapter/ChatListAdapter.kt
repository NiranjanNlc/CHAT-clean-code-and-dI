package org.lniranjan.chatclone.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.lniranjan.chatclone.databinding.ChatItemBinding
import org.lniranjan.chatclone.modal.ChatItem

class ChatListAdapter: ListAdapter<ChatItem,ChatListAdapter.ChatListViewHolder>(ChatItemDiffCallback) {

    companion object ChatItemDiffCallback : DiffUtil.ItemCallback<ChatItem>()
    {
        override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean
        {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem.equals(newItem)
        }
    }
    class ChatListViewHolder(var items: ChatItemBinding): RecyclerView.ViewHolder(items.root) {
        fun bind(chatItems: ChatItem) {
            items.userChats = chatItems
        }
        companion object {
            fun from(parent: ViewGroup): ChatListViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ChatItemBinding.inflate(inflater)
                return ChatListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        return ChatListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        val chatItem = getItem(position)
        holder.bind(chatItem)
        holder.items.executePendingBindings()
    }
}