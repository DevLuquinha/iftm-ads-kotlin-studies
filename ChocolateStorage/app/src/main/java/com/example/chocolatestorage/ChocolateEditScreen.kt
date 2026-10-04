package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class ChocolateEditScreen : AppCompatActivity() {
    lateinit var chocolateIdEditText: EditText
    lateinit var amountCocoaEditText: EditText
    lateinit var chocolateColorRadioGroup: RadioGroup
    lateinit var chocolatePriceEditText: EditText

    lateinit var cancelButton: Button
    lateinit var editChocolateButton: Button
    lateinit var findChocolateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chocolate_edit_screen)

        chocolateIdEditText = findViewById(R.id.et_chocolateId2)
        amountCocoaEditText = findViewById(R.id.et_amountCocoa2)
        chocolateColorRadioGroup = findViewById(R.id.rg_chocolateColor2)
        chocolatePriceEditText = findViewById(R.id.et_chocolatePrice2)

        cancelButton = findViewById(R.id.btn_cancelChocolateEditScreen)
        editChocolateButton = findViewById(R.id.btn_editChocolate)
        findChocolateButton = findViewById(R.id.btn_findChocolateToEdit)

        cancelButton.setOnClickListener {
            this.finish()
        }

        findChocolateButton.setOnClickListener {
        }

        editChocolateButton.setOnClickListener {
        }
    }
}
