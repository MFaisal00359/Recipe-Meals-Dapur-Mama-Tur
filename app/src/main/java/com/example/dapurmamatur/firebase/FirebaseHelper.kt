package com.example.dapurmamatur.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

object FirebaseHelper {

    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

//    fun getCurrentUser() = auth.currentUser

    fun signIn(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)
                } else {
                    val errorMessage = when (task.exception) {
                        is FirebaseAuthInvalidCredentialsException -> "Invalid credentials. Please check your email and password."
                        is FirebaseAuthInvalidUserException -> "No account found with this email."
                        else -> "Authentication failed: ${task.exception?.message}"
                    }
                    onComplete(false, errorMessage)
                }
            }
    }

    fun signUp(email: String, password: String, username: String, onComplete: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUserProfile(user, username, onComplete)
                } else {
                    onComplete(false, "Registration failed: ${task.exception?.message}")
                }
            }
    }

    private fun updateUserProfile(user: FirebaseUser?, username: String, onComplete: (Boolean, String?) -> Unit) {
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(username)
            .build()

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)
                } else {
                    onComplete(false, "Profile update failed: ${task.exception?.message}")
                }
            }
    }

}
