package org.lniranjan.chatclone.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.ActivityWelcomeBinding

@AndroidEntryPoint
class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        supportActionBar!!.title = "Welcome"


        try {
            binding.welcomeViewPager.adapter = WelcomePagerAdapter(supportFragmentManager, lifecycle)

            TabLayoutMediator(binding.tabLayout, binding.welcomeViewPager) { tab, position ->
                when(position){
                    0 -> tab.text = "Chats"
                    1 -> tab.text = "Contacts"
                    else -> tab.text = "Chats"
                }
            }.attach()
        }
        catch (e: Exception) {
            e.printStackTrace()
        }

    }
}