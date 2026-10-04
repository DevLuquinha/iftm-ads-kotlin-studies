package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ChocolateRecordScreen : AppCompatActivity() {
    lateinit var chocolateIdEditText: EditText
    lateinit var amountCocoaEditText: EditText
    lateinit var chocolateColorRadioGroup: RadioGroup
    lateinit var chocolatePriceEditText: EditText
    lateinit var cancelButton: Button
    lateinit var createChocolateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chocolate_record_screen)

        chocolateIdEditText = findViewById(R.id.et_chocolateId)
        amountCocoaEditText = findViewById(R.id.et_amountCocoa)
        chocolateColorRadioGroup = findViewById(R.id.rg_chocolateColor)
        chocolatePriceEditText = findViewById(R.id.et_chocolatePrice)
        cancelButton = findViewById(R.id.btn_cancelChocolateRecordScreen)
        createChocolateButton = findViewById(R.id.btn_createChocolate)
    }
}