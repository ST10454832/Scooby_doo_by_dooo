// TamagotchiActivity.kt
package com.st10454832.scooby_doo_by_dooo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class TamagotchiActivity : AppCompatActivity() {

    private lateinit var petImageView: ImageView
    private lateinit var healthTextView: TextView
    private lateinit var hungerTextView: TextView
    private lateinit var cleanlinessTextView: TextView
    private lateinit var feedButton: Button
    private lateinit var cleanButton: Button
    private lateinit var playButton: Button
    private lateinit var healthProgressBar: ProgressBar
    private lateinit var hungerProgressBar: ProgressBar
    private lateinit var cleanlinessProgressBar: ProgressBar

    private var pet: Pet = Pet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tamagotchi)

        petImageView = findViewById(R.id.pet_image_view)
        healthTextView = findViewById(R.id.health_text_view)
        hungerTextView = findViewById(R.id.hunger_text_view)
        cleanlinessTextView = findViewById(R.id.cleanliness_text_view)
        feedButton = findViewById(R.id.feed_button)
        cleanButton = findViewById(R.id.clean_button)
        playButton = findViewById(R.id.play_button)
        healthProgressBar = findViewById(R.id.health_progress_bar)
        hungerProgressBar = findViewById(R.id.hunger_progress_bar)
        cleanlinessProgressBar = findViewById(R.id.cleanliness_progress_bar)

        feedButton.setOnClickListener {
            pet.feed()
            updatePetImage(R.drawable.scoobyboo_eating)
            updateStatusValues()
        }

        cleanButton.setOnClickListener {
            pet.clean()
            updatePetImage(R.drawable.scobydo_showering)
            updateStatusValues()
        }

        playButton.setOnClickListener {
            pet.play()
            updatePetImage(R.drawable.scoobyboo_playing)
            updateStatusValues()
        }
    }

    private fun updatePetImage(imageResource: Int) {
        petImageView.setImageResource(imageResource)
    }

    private fun updateStatusValues() {
        healthTextView.text = "Health: ${pet.health}"
        hungerTextView.text = "Hunger: ${pet.hunger}"
        cleanlinessTextView.text = "Cleanliness: ${pet.cleanliness}"
        healthProgressBar.progress = pet.health
        hungerProgressBar.progress = pet.hunger
        cleanlinessProgressBar.progress = pet.cleanliness
    }
}

data class Pet(var health: Int = 100, var hunger: Int = 50, var cleanliness: Int = 50) {
    fun feed() {
        hunger -= 10
        health += 5
    }

    fun clean() {
        cleanliness += 10
        health += 5
    }

    fun play() {
        hunger += 10
        health += 5
    }
}
