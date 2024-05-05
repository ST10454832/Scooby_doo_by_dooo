package com.st10454832.scooby_doo_by_dooo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var petImage: ImageView
    private lateinit var healthTextView: TextView
    private lateinit var hungerTextView: TextView
    private lateinit var cleanlinessTextView: TextView
    private lateinit var healthProgressBar: ProgressBar
    private lateinit var hungerProgressBar: ProgressBar
    private lateinit var cleanlinessProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page2)
        
        petImage = findViewById(R.id.pet_image)
        healthTextView = findViewById(R.id.health_text_view)
        hungerTextView = findViewById(R.id.hunger_text_view)
        cleanlinessTextView = findViewById(R.id.cleanliness_text_view)
        healthProgressBar = findViewById(R.id.health_progress_bar)
        hungerProgressBar = findViewById(R.id.hunger_progress_bar)
        cleanlinessProgressBar = findViewById(R.id.cleanliness_progress_bar)

        val feedButton = findViewById<Button>(R.id.feed_button)
        feedButton.setOnClickListener {
            petImage.setImageResource(R.drawable.feeding_icon)
            updateStatusValues(10, -5, 0) // adjust health, hunger, and cleanliness values accordingly
        }

        val cleanButton = findViewById<Button>(R.id.clean_button)
        cleanButton.setOnClickListener {
            petImage.setImageResource(R.drawable.cleaning_icon)
            updateStatusValues(0, 0, 10) // adjust health, hunger, and cleanliness values accordingly
        }

        val playButton = findViewById<Button>(R.id.play_button)
        playButton.setOnClickListener {
            petImage.setImageResource(R.drawable.playing_icon)
            updateStatusValues(5, 5, 0) // adjust health, hunger, and cleanliness values accordingly
        }
    }

    private fun updateStatusValues(healthDelta: Int, hungerDelta: Int, cleanlinessDelta: Int) {
        // update the pet's status values based on the action performed
        val healthValue = healthTextView.text.toString().toInt() + healthDelta
        val hungerValue = hungerTextView.text.toString().toInt() + hungerDelta
        val cleanlinessValue = cleanlinessTextView.text.toString().toInt() + cleanlinessDelta

        healthTextView.text = healthValue.toString()
        hungerTextView.text = hungerValue.toString()
        cleanlinessTextView.text = cleanlinessValue.toString()

        // update the progress bars
        healthProgressBar.progress = healthValue
        hungerProgressBar.progress = hungerValue
        cleanlinessProgressBar.progress = cleanlinessValue
    }
}