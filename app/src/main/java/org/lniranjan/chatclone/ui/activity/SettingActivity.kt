package org.lniranjan.chatclone.ui.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import org.lniranjan.chatclone.R
import org.lniranjan.chatclone.databinding.ActivitySettingBinding
import org.lniranjan.chatclone.modal.ProfileDetail
import org.lniranjan.chatclone.ui.viewmodel.SettingViewModel

@AndroidEntryPoint
class SettingActivity : AppCompatActivity() {

    lateinit var binding: ActivitySettingBinding
    val viewModel by viewModels<SettingViewModel>()
    var isEditMode: Boolean = false

    private val REQUEST_PHOTO_PERMISSION = 1
    private var loadingImage = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcloudinary.com%2Fblog%2Feasy_image_loading_and_optimization_with_cloudinary_and_fresco&psig=AOvVaw2WgdiYXEK57EcYEJNpYopL&ust=1671607043091000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCMil5dLTh_wCFQAAAAAdAAAAABAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) 
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting)
        //  change the  title of the action bar
        supportActionBar?.title = " Update  the profile info"
        //get user info from intent and use the id from firebase for testing purposes only
//        val userId = intent.getStringExtra("userId")?:"T520rsExXWdb5K4LqcHK21Mdtjo2"
//        loadAndSetUserIinfo(userId.toString())
//        setOnClickListenerForProfilePhoto()
//        setObserver()
        setEditMode()
        binding.updateSettingsBtn.setOnClickListener {
            toggleEditMode()
        }
    }

    private fun toggleEditMode() {
        isEditMode = !isEditMode
        if (isEditMode) {
            binding.updateSettingsBtn.text = "Save Profile"
            setEditMode()
        } else {
            binding.updateSettingsBtn.text = "Edit Profile"
            setEditMode()
        }
    }

    private fun setEditMode() {
        binding.setUserName.isEnabled = isEditMode
        binding.setBio.isEnabled = isEditMode

    }

    private fun loadAndSetUserIinfo(userId: String?) {
        Log.i("SettingActivity", "loadAndSetUserIinfo: $userId")
//        Glide.with(this).load(loadingImage).into(binding.setProfileImage)
//        viewModel.getProfileDetail(userId.toString())
    }


    private fun setObserver() {
        Log.i("SettingActivity", "setObserver: observed ")
        viewModel._profileDetail.observe(this, {
            Log.i("SettingActivity", "setObserver: $it")
            binding.profileDetail = ProfileDetail(it.name, it.profilePhoto, it.bio)
          loadingImage = it.profilePhoto.toString()
        })
    }


    private fun setOnClickListenerForProfilePhoto() {
        binding.setProfileImage.setOnClickListener {
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
        binding.updateSettingsBtn.setOnClickListener {
            viewModel.updateProfileDetail(
                ProfileDetail(name = binding.setUserName.text.toString(),
                bio = binding.setBio.text.toString(),
                profilePhoto = binding.profileDetail?.profilePhoto)
            )
        }
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
    val resltPhot =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val selectedImageUri = result.data?.data
                if (selectedImageUri != null) {
                    viewModel.uploadProfileImage(selectedImageUri)
                    binding.setProfileImage.setImageURI(selectedImageUri)
                }
            }
        }

    fun selectImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*" // only image
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