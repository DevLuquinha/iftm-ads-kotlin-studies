package com.example.computermanagement

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomerRecordScreen : AppCompatActivity() {
    lateinit var cpfEditText: EditText
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var phoneNumberEditText: EditText
    lateinit var computerModelEditText: EditText
    lateinit var computerPriceEditText: EditText
    lateinit var createCustomerButton: Button
    lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_record_screen)

        cpfEditText = findViewById(R.id.et_cpf)
        nameEditText = findViewById(R.id.et_name)
        emailEditText = findViewById(R.id.et_email)
        phoneNumberEditText = findViewById(R.id.et_phoneNumber)
        computerModelEditText = findViewById(R.id.et_computerModel)
        computerPriceEditText = findViewById(R.id.et_computerPrice)
        createCustomerButton = findViewById(R.id.btn_create)
        cancelButton = findViewById(R.id.btn_cancel)

        cancelButton.setOnClickListener {
            this.finish()
        }

        createCustomerButton.setOnClickListener {
            val customer = Customer(
                cpfEditText.text.toString(),
                nameEditText.text.toString(),
                emailEditText.text.toString(),
                phoneNumberEditText.text.toString(),
                computerModelEditText.text.toString(),
                computerPriceEditText.text.toString().toDouble(),
            )
        }
    }
}