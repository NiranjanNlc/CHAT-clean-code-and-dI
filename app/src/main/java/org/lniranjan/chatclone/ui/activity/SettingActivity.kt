package org.lniranjan.chatclone.ui.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import org.lniranjan.chatclone.databinding.ActivitySettingBinding
import org.lniranjan.chatclone.modal.UserDetail
import org.lniranjan.chatclone.ui.viewmodel.SettingViewModel

@AndroidEntryPoint
class SettingActivity : AppCompatActivity() {

    private lateinit var bindind: ActivitySettingBinding
    private val viewModel by viewModels<SettingViewModel>()
    private val REQUEST_PHOTO_PERMISSION = 1
    private val SELECT_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(bindind.root)
        //  change the  title of the action bar
        supportActionBar?.title = " Update  the profile info"
        setObserver()
        bindind.setProfileImage.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPhotoPermission()
            } else {
                selectImage()
            }
        }
    }

    private fun setObserver() {
        viewModel._profileDetail.observe(this, {
            bindind.profileDetail = it
        })
    }

    private fun updateProfileDetail() {

    }

    private fun uploadProfilePhoto() {
        //askes for permsion pf photo

    }

    fun requestPhotoPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is not granted, so request it
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                REQUEST_PHOTO_PERMISSION
            )
        }
    }

    fun selectImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*" // only image
        val resltPhot =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val selectedImageUri = result.data?.data
                    if (selectedImageUri != null) {
                        bindind.setProfileImage.setImageURI(selectedImageUri)
                    }
                }
            }
        resltPhot.launch(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_PHOTO_PERMISSION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission was granted, so do something with the photos
                    selectImage()
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
                } else {
                    // Permission denied, so show a message to the user
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
            // Other request codes can go here
        }
    }
}