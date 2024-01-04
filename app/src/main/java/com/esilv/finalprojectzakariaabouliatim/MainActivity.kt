package com.esilv.finalprojectzakariaabouliatim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageViewGoogle = findViewById<ImageView>(R.id.imageViewGoogle)
        val imageViewGithub = findViewById<ImageView>(R.id.imageViewGithub)
        val imageViewSpotify = findViewById<ImageView>(R.id.imageViewSpotify)
        val buttonLogin = findViewById<Button>(R.id.ButtonLogin)


        buttonLogin.setOnClickListener {
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                showToast("Please fill all the fields")
            } else {
                showToast("Login successful")
                val intent = Intent(this, DisneyViewerActivity::class.java)
                startActivity(intent)
            }
        }
        imageViewGoogle.setOnClickListener {
            showToast("Connected with Google")
            val intent = Intent(this, DisneyViewerActivity::class.java)
            startActivity(intent)
        }

        imageViewGithub.setOnClickListener {
            showToast("Connected with Github")
            val intent = Intent(this, DisneyViewerActivity::class.java)
            startActivity(intent)
        }

        imageViewSpotify.setOnClickListener {
            showToast("Connected with Spotify")
            val intent = Intent(this, DisneyViewerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_notification_layout, findViewById(R.id.toastTextView))

        val toastTextView = layout.findViewById<TextView>(R.id.toastTextView)
        toastTextView.text = message

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}

