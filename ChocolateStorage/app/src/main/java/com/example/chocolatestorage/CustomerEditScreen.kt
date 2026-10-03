package com.example.chocolatestorage

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
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

        val dbHelper = MyDatabaseHelper(this)

        findCustomerButton.setOnClickListener {
            if (cpfEditText.text.isEmpty()){
                Toast.makeText(
                    this,
                    "Error! Type a CPF to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val customerList = CustomerDbUtils.getAllCustomers(dbHelper)

            val customer = customerList.find {
                c -> c.cpf.equals(cpfEditText.text.toString())
            }

            if (customer == null){
                Toast.makeText(
                    this,
                    "Error! The user doesn't exists, check if the CPF was typed correctly!",
                    Toast.LENGTH_SHORT
                ).show()

                nameEditText.text.clear()
                emailEditText.text.clear()
                phoneNumberEditText.text.clear()
                ageEditText.text.clear()
                customerExists = false
                return@setOnClickListener
            }

            nameEditText.setText(customer.name)
            emailEditText.setText(customer.email)
            phoneNumberEditText.setText(customer.phoneNumber)
            ageEditText.setText(customer.age.toString())
            customerExists = true
        }

        editCustomerButton.setOnClickListener {
            if (!customerExists){
                Toast.makeText(
                    this,
                    "Error! The user doesn't exists, check if the CPF was typed correctly!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val customer = Customer(
                cpfEditText.text.toString(),
                nameEditText.text.toString(),
                emailEditText.text.toString(),
                phoneNumberEditText.text.toString(),
                ageEditText.text.toString().toInt(),
            )

            val writableInstance = dbHelper.writableDatabase
            val contentValues = ContentValues().apply {
                put(MyDatabaseHelper.CUSTOMER_COLUMN_CPF, customer.cpf)
                put(MyDatabaseHelper.CUSTOMER_COLUMN_NAME, customer.name)
                put(MyDatabaseHelper.CUSTOMER_COLUMN_EMAIL, customer.email)
                put(MyDatabaseHelper.CUSTOMER_COLUMN_PHONE_NUMBER, customer.phoneNumber)
                put(MyDatabaseHelper.CUSTOMER_COLUMN_AGE, customer.age)
            }

            val rowIndex = writableInstance.update(MyDatabaseHelper.CUSTOMER_TABLE_NAME, contentValues, "${MyDatabaseHelper.CUSTOMER_COLUMN_CPF} = ?", arrayOf(customer.cpf))
            if (rowIndex < 1){
                Toast.makeText(
                    this,
                    "Something was wrong :(, your customer wasn't edited on the database",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "The customer has been successfully edited!",
                    Toast.LENGTH_SHORT
                ).show()

                cpfEditText.text.clear()
                nameEditText.text.clear()
                emailEditText.text.clear()
                phoneNumberEditText.text.clear()
                ageEditText.text.clear()

                this.finish()
            }
        }
    }
}