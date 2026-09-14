package com.example.learningcomponents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondScreen : AppCompatActivity() {
    lateinit var goToFirstScreenButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        goToFirstScreenButton = findViewById(R.id.btn_toFirstScreen)

        goToFirstScreenButton.setOnClickListener {
            val switchScreen = Intent(this, FirstScreen::class.java)
            this.startActivity(switchScreen)
        }
    }
}