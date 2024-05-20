package com.example.dapurmamatur.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.example.dapurmamatur.R
import com.example.dapurmamatur.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    private lateinit var binding: ActivityProfileBinding
    private lateinit var storageReference: StorageReference

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            binding.profileImage.setImageURI(it)
            uploadImageToFirebase(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser ?: run {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        storageReference = FirebaseStorage.getInstance().reference.child("profile_images/${user.uid}")

        val rootView = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButtonProfile.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        binding.EmailInputView.text = user.email
        binding.UsernameInputView.text = user.displayName ?: "Username not set"

        binding.buttonLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.profileImageAdd.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        loadProfileImage()
        setupBottomNavigation()
    }

    private fun loadProfileImage() {
        storageReference.downloadUrl.addOnSuccessListener { uri ->
            binding.profileImage.load(uri.toString())
        }.addOnFailureListener {
            // Handle failure
        }
    }

    private fun uploadImageToFirebase(uri: Uri) {
        storageReference.putFile(uri).addOnSuccessListener {
            storageReference.downloadUrl.addOnSuccessListener { downloadUri ->
                updateProfileImageUri(downloadUri)
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Image upload failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateProfileImageUri(uri: Uri) {
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setPhotoUri(uri)
            .build()

        user.updateProfile(profileUpdates).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Profile image updated", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Profile image update failed", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.navigation_favorite -> {
                    startActivity(Intent(this, FavoriteActivity::class.java))
                    false
                }
                R.id.navigation_profile -> true
                else -> false
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.navigation_profile
    }


}
