package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomerRecordScreen : AppCompatActivity() {
    lateinit var customerSectionRadioGroup: RadioGroup

    lateinit var cpfEditText: EditText
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var phoneNumberEditText: EditText
    lateinit var ageEditText: EditText

    lateinit var cancelButton: Button
    lateinit var goChocolateRecordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_record_screen)

        customerSectionRadioGroup = findViewById(R.id.rg_customerExistsSection)

        cpfEditText = findViewById(R.id.et_cpf)
        nameEditText = findViewById(R.id.et_name)
        emailEditText = findViewById(R.id.et_email)
        phoneNumberEditText = findViewById(R.id.et_phoneNumber)
        ageEditText = findViewById(R.id.et_age)

        cancelButton = findViewById(R.id.btn_cancelCustomerRecordScreen)
        goChocolateRecordButton = findViewById(R.id.btn_goChocolateRecord)
    }
}