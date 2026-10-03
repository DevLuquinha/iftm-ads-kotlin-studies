package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomerSearchScreen : AppCompatActivity() {
    lateinit var cpfEditText: EditText
    lateinit var searchCustomerButton: Button
    lateinit var searchCustomerResultTextView: TextView
    lateinit var goBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_search_screen)

        cpfEditText = findViewById(R.id.et_cpf4)
        searchCustomerButton = findViewById(R.id.btn_searchCustomer)
        searchCustomerResultTextView = findViewById(R.id.tv_searchCustomerResult)
        goBackButton = findViewById(R.id.btn_customerSearchToHome)

        goBackButton.setOnClickListener {
            finish()
        }

        searchCustomerButton.setOnClickListener {
            if (cpfEditText.text.isEmpty()){
                Toast.makeText(
                    this,
                    "Error! Type a CPF to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val dbHelper = MyDatabaseHelper(this)
            val allCustomersList = CustomerDbUtils.getAllCustomers(dbHelper)
            val customer = allCustomersList.find {
                c -> c.cpf.equals(cpfEditText.text.toString())
            }

            if (customer == null){
                Toast.makeText(
                    this,
                    "Error! The user doesn't exists, check if the CPF was typed correctly!",
                    Toast.LENGTH_SHORT
                ).show()

                searchCustomerResultTextView.text = "Error! The user doesn't exists, check if the CPF was typed correctly!"
                return@setOnClickListener
            }

            searchCustomerResultTextView.text = customer.toString()
        }
    }
}