package com.example.chocolatestorage

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
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

        cancelButton.setOnClickListener {
            this.finish()
        }

        goChocolateRecordButton.setOnClickListener {
            if (cpfEditText.text.isEmpty()){
                showMessage("Error! Type the CPF to continue")
                return@setOnClickListener
            }

            val dbHelper = MyDatabaseHelper(this)

            if (customerSectionRadioGroup.checkedRadioButtonId == R.id.rb_customerExists){
                // Check the CPF on database
                // If correct, continue to next screen
            } else {
                val customer = Customer(
                    cpfEditText.text.toString(),
                    nameEditText.text.toString(),
                    emailEditText.text.toString(),
                    phoneNumberEditText.text.toString(),
                    ageEditText.text.toString().toInt()
                )

                val contentValues = ContentValues().apply {
                    put(MyDatabaseHelper.CUSTOMER_COLUMN_CPF, customer.cpf)
                    put(MyDatabaseHelper.CUSTOMER_COLUMN_NAME, customer.name)
                    put(MyDatabaseHelper.CUSTOMER_COLUMN_EMAIL, customer.email)
                    put(MyDatabaseHelper.CUSTOMER_COLUMN_PHONE_NUMBER, customer.phoneNumber)
                    put(MyDatabaseHelper.CUSTOMER_COLUMN_AGE, customer.age)
                }

                val writableInstance = dbHelper.writableDatabase
                val rowId = writableInstance.insert(
                    MyDatabaseHelper.CUSTOMER_TABLE_NAME,
                    null,
                    contentValues
                )

                if (rowId == -1L){
                    Toast.makeText(
                        this,
                        "Something was wrong :(, your customer wasn't added on the database",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                Toast.makeText(
                    this,
                    "The customer has been successfully added!",
                    Toast.LENGTH_SHORT
                ).show()

                cpfEditText.text.clear()
                nameEditText.text.clear()
                emailEditText.text.clear()
                phoneNumberEditText.text.clear()
                ageEditText.text.clear()
            }
        }
    }

    fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}