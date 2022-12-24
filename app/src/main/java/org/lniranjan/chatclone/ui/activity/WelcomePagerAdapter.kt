package org.lniranjan.chatclone.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.lniranjan.chatclone.ui.fragment.ChatListFragment
import org.lniranjan.chatclone.ui.fragment.ContactListFragment

/* created pager adapter for welcome activity */
class WelcomePagerAdapter(fm: FragmentManager, lc : Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ChatListFragment()
            1 -> ContactListFragment()
            else -> ChatListFragment()
        }
    }
}
