package org.lniranjan.chatclone.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.lniranjan.chatclone.databinding.ActivitySettingBinding
import org.lniranjan.chatclone.modal.UserDetail
import org.lniranjan.chatclone.ui.viewmodel.SettingViewModel

@AndroidEntryPoint
class SettingActivity : AppCompatActivity() {

    private lateinit var bindind : ActivitySettingBinding
    private val viewModel by viewModels<SettingViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(bindind.root)
     //  change the  title of the action bar
        supportActionBar?.title = " Update  the profile info"
        setObserver()
    }

    private fun setObserver() {
        viewModel._profileDetail.observe(this, {
                bindind.profileDetail = it
        })
    }

    private fun updateProfileDetail() {

    }
    private fun uploadProfilePhoto() {
    }
}