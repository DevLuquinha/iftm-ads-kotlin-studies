package com.example.computermanagement

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

            val dbHelper = MyDatabaseHelper(this)
            val writableDbInstance = dbHelper.writableDatabase
            val valuesToInsert = ContentValues().apply {
                put(MyDatabaseHelper.COLUMN_CPF, customer.getCpf())
                put(MyDatabaseHelper.COLUMN_NAME, customer.getName())
                put(MyDatabaseHelper.COLUMN_EMAIL, customer.getEmail())
                put(MyDatabaseHelper.COLUMN_PHONE_NUMBER, customer.getPhoneNumber())
                put(MyDatabaseHelper.COLUMN_COMPUTER_MODEL, customer.getComputerModel())
                put(MyDatabaseHelper.COLUMN_COMPUTER_PRICE, customer.getComputerPrice())
            }

            val rowIndex = writableDbInstance.insert(MyDatabaseHelper.TABLE_NAME, null, valuesToInsert)
            if (rowIndex == -1L){
                Toast.makeText(
                    this,
                    "Something was wrong :(, your customer wasn't added on the database",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "The customer has been successfully added!",
                    Toast.LENGTH_SHORT
                ).show()

                cpfEditText.text.clear()
                nameEditText.text.clear()
                emailEditText.text.clear()
                phoneNumberEditText.text.clear()
                computerModelEditText.text.clear()
                computerPriceEditText.text.clear()

                this.finish()
            }
        }
    }
}