package com.example.miscellanyproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen01 : AppCompatActivity() {
    lateinit var academicRecordEditText : EditText
    lateinit var studentNameEditText : EditText
    lateinit var periodEditText : EditText
    lateinit var pdmGradle : EditText
    lateinit var registerDataButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_01)

        academicRecordEditText = findViewById(R.id.et_academicRecords)
        studentNameEditText = findViewById(R.id.et_studentName)
        periodEditText = findViewById(R.id.et_period)
        pdmGradle = findViewById(R.id.et_pdmGrade)
        registerDataButton = findViewById(R.id.btn_registerData)

        registerDataButton.setOnClickListener {
            val dataLoader = Bundle()
            dataLoader.putString("123", academicRecordEditText.text?.toString())
            dataLoader.putString("456", studentNameEditText.text?.toString())
            dataLoader.putInt("789", periodEditText.text.toString().toInt())
            dataLoader.putDouble("321", pdmGradle.text.toString().toDouble())

            val switchScreenIntent = Intent(this, Screen02::class.java)
            switchScreenIntent.putExtras(dataLoader)
            this.startActivity(switchScreenIntent)
        }
    }
}