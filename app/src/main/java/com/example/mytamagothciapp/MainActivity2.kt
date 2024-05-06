package com.example.mytamagothciapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


//Name: Taahir Hoosen
// Student Number: ST10445196

class GameActivity : AppCompatActivity() {

    //initializing variables using this command
    private lateinit var dogImageView: ImageView
    private lateinit var healthTextView: TextView
    private lateinit var hungerTextView: TextView
    private lateinit var cleanlinessTextView: TextView

    private var health = 100
    private var hunger = 0
    private var cleanliness = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //We are declaring the variables
        dogImageView = findViewById(R.id.dogImageView)
        healthTextView = findViewById(R.id.healthTextView)
        hungerTextView = findViewById(R.id.hungerTextView)
        cleanlinessTextView = findViewById(R.id.cleanlinessTextView)
    }

    fun onFeedClicked(view: android.view.View) {
        dogImageView.setImageResource(R.drawable.dogeat)
        // The values will change based on the instructions below
        health += 10
        if (health > 100) health = 100
        hunger -= 20
        if (hunger < 0) hunger = 0
        updateStatus()
        Toast.makeText(this, "Feeding the dog!", Toast.LENGTH_SHORT).show()
    }

    fun onCleanClicked(view: android.view.View) {
        dogImageView.setImageResource(R.drawable.dogbath)
        // The values will change based on the instructions below
        health += 20
        if (health > 100) health = 100
        cleanliness += 20
        if (cleanliness > 100) cleanliness = 100
        updateStatus()
        Toast.makeText(this, "Cleaning the dog!", Toast.LENGTH_SHORT).show()
    }

    fun onPlayClicked(view: android.view.View) {
        dogImageView.setImageResource(R.drawable.dogplay)
        // The values will change based on the instructions below
        hunger += 20
        if (hunger > 100) hunger = 100
        cleanliness -= 20
        if (cleanliness < 0) cleanliness = 0
        updateStatus()
        Toast.makeText(this, "Playing with the dog!", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun updateStatus() {
        healthTextView.text = "Health: $health%"
        hungerTextView.text = "Hunger: $hunger%"
        cleanlinessTextView.text = "Cleanliness: $cleanliness%"
    }
}