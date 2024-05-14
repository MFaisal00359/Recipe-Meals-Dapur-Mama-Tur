package com.example.dapurmamatur.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dapurmamatur.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menambahkan OnClickListener untuk tombol kembali
        findViewById<View>(R.id.backButton).setOnClickListener {
            // Kembali ke MainActivity saat tombol kembali diklik
            startActivity(Intent(this, LoginActivity::class.java))
            // Selesaikan aktivitas saat ini agar tidak dapat kembali lagi
            finish()
        }
    }
}
