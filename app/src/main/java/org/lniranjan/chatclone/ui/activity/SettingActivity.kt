package org.lniranjan.chatclone.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.lniranjan.chatclone.R

/* activity to displau and update the user info */

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        //  change the  title of the action bar
        supportActionBar?.title = " Update  the profile info"

    }
}