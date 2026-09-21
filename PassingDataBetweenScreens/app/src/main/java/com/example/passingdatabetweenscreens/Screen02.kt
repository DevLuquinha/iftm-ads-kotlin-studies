package com.example.passingdatabetweenscreens

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Screen02 : AppCompatActivity() {
    lateinit var studentsListView : ListView
    lateinit var goBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_02)

        studentsListView = findViewById(R.id.lv_students)
        goBackButton = findViewById(R.id.btn_goBack)

        goBackButton.setOnClickListener {
            this.finish()
        }
    }
}