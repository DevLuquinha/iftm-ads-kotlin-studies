package com.example.computermanagement

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CustomerEditScreen : AppCompatActivity() {
    lateinit var cpfEditText: EditText
    lateinit var searchCpfToEditButton: Button
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var phoneNumberEditText: EditText
    lateinit var computerModelEditText: EditText
    lateinit var computerPriceEditText: EditText
    lateinit var editCustomerButton: Button
    lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_edit_screen)

        cpfEditText = findViewById(R.id.et_cpfEdit)
        searchCpfToEditButton = findViewById(R.id.btn_searchCpfToEdit)
        nameEditText = findViewById(R.id.et_nameEdit)
        emailEditText = findViewById(R.id.et_emailEdit)
        phoneNumberEditText = findViewById(R.id.et_phoneNumberEdit)
        computerModelEditText = findViewById(R.id.et_computerModelEdit)
        computerPriceEditText = findViewById(R.id.et_computerPriceEdit)
        editCustomerButton = findViewById(R.id.btn_editCustomer)
        cancelButton = findViewById(R.id.btn_cancelEdit)

        val dbHelper = MyDatabaseHelper(this)

        searchCpfToEditButton.setOnClickListener {
            val customerList = ArrayList<Customer>()
            val readableDbInstance = dbHelper.readableDatabase
            var resultCursor = readableDbInstance.rawQuery(
                "SELECT * FROM ${MyDatabaseHelper.TABLE_NAME} WHERE ${MyDatabaseHelper.COLUMN_CPF} = ?", arrayOf(cpfEditText.text.toString()))

            Log.i("TEST-", resultCursor.toString())

            with(resultCursor){
                while(moveToNext()){
                    val cpf = getString(getColumnIndexOrThrow(MyDatabaseHelper.COLUMN_CPF))
                    val name = getString(getColumnIndexOrThrow(MyDatabaseHelper.COLUMN_NAME))
                    val email = getString(getColumnIndexOrThrow(MyDatabaseHelper.COLUMN_EMAIL))
                    val phoneNumber = getString(getColumnIndexOrThrow(MyDatabaseHelper.COLUMN_PHONE_NUMBER))
                    val computerModel = getString(getColumnIndexOrThrow(MyDatabaseHelper.COLUMN_COMPUTER_MODEL))
                    val computerPrice = getDouble(getColumnIndexOrThrow(MyDatabaseHelper.COLUMN_COMPUTER_PRICE))

                    val customer = Customer(cpf, name, email, phoneNumber, computerModel, computerPrice)
                    customerList.add(customer)
                }
            }

            if (customerList.count() != 1){
                Toast.makeText(
                    this,
                    "Something was wrong :(, your customer wasn't founded on the database",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val customer = customerList.first()

                nameEditText.setText(customer.getName())
                emailEditText.setText(customer.getEmail())
                phoneNumberEditText.setText(customer.getPhoneNumber())
                computerModelEditText.setText(customer.getComputerModel())
                computerPriceEditText.setText(customer.getComputerPrice().toString())
            }
        }

        editCustomerButton.setOnClickListener {
            val customer = Customer(
                cpfEditText.text.toString(),
                nameEditText.text.toString(),
                emailEditText.text.toString(),
                phoneNumberEditText.text.toString(),
                computerModelEditText.text.toString(),
                computerPriceEditText.text.toString().toDouble(),
            )

            val writableDbInstance = dbHelper.writableDatabase
            val valuesToInsert = ContentValues().apply {
                put(MyDatabaseHelper.COLUMN_CPF, customer.getCpf())
                put(MyDatabaseHelper.COLUMN_NAME, customer.getName())
                put(MyDatabaseHelper.COLUMN_EMAIL, customer.getEmail())
                put(MyDatabaseHelper.COLUMN_PHONE_NUMBER, customer.getPhoneNumber())
                put(MyDatabaseHelper.COLUMN_COMPUTER_MODEL, customer.getComputerModel())
                put(MyDatabaseHelper.COLUMN_COMPUTER_PRICE, customer.getComputerPrice())
            }

            val rowIndex = writableDbInstance.update(MyDatabaseHelper.TABLE_NAME, valuesToInsert, "${MyDatabaseHelper.COLUMN_CPF} = ?", arrayOf(customer.getCpf()))
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
                computerModelEditText.text.clear()
                computerPriceEditText.text.clear()

                this.finish()
            }
        }

        cancelButton.setOnClickListener{
            this.finish()
        }
    }
}