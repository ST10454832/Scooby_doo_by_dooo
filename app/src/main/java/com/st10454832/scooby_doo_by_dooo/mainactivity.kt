// WelcomeActivity.kt
package com.st10454832.scooby_doo_by_dooo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    private lateinit var welcome_Image_View: ImageView
    private lateinit var welcomeTextView: TextView
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcome_Image_View = findViewById(R.id.welcome_image_view)
        welcomeTextView = findViewById(R.id.welcome_text_view)
        startButton = findViewById(R.id.start_button)

        startButton.setOnClickListener {
            startActivity(TamagotchiActivity.)
        }
    }
}

