package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChocolateDeleteScreen : AppCompatActivity() {
    lateinit var chocolateIdEditText: EditText
    lateinit var cancelButton: Button
    lateinit var deleteChocolateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chocolate_delete_screen)

        chocolateIdEditText = findViewById(R.id.et_chocolateId3)
        cancelButton = findViewById(R.id.btn_cancelChocolateDeleteScreen)
        deleteChocolateButton = findViewById(R.id.btn_deleteChocolate)

        cancelButton.setOnClickListener {
            this.finish()
        }

        deleteChocolateButton.setOnClickListener {
        }
    }
}
