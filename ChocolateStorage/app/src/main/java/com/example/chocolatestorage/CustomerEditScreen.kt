package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomerEditScreen : AppCompatActivity() {
    lateinit var cpfEditText: EditText
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var phoneNumberEditText: EditText
    lateinit var ageEditText: EditText

    lateinit var cancelButton: Button
    lateinit var editCustomerButton: Button
    lateinit var findCustomerButton: Button

    private var customerExists: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_edit_screen)

        cpfEditText = findViewById(R.id.et_cpf2)
        nameEditText = findViewById(R.id.et_name2)
        emailEditText = findViewById(R.id.et_email2)
        phoneNumberEditText = findViewById(R.id.et_phoneNumber2)
        ageEditText = findViewById(R.id.et_age2)

        cancelButton = findViewById(R.id.btn_cancelCustomerEditScreen)
        editCustomerButton = findViewById(R.id.btn_editCustomer)
        findCustomerButton = findViewById(R.id.btn_findCustomerToEdit)

        cancelButton.setOnClickListener {
            this.finish()
        }

        findCustomerButton.setOnClickListener {

        }

        editCustomerButton.setOnClickListener {
            if (!customerExists){
                Toast.makeText(
                    this,
                    "The user doesn't exists, check if the CPF was typed correctly!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }
        }
    }
}