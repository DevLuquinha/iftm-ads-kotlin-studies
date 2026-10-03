package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomerDeleteScreen : AppCompatActivity() {
    lateinit var cpfEditText: EditText
    lateinit var cancelButton: Button
    lateinit var deleteCustomerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_delete_screen)

        cpfEditText = findViewById(R.id.et_cpf3)
        cancelButton = findViewById(R.id.btn_cancelCustomerDeleteScreen)
        deleteCustomerButton = findViewById(R.id.btn_deleteCustomer)

        cancelButton.setOnClickListener {
            this.finish()
        }

        deleteCustomerButton.setOnClickListener {
            if (cpfEditText.text.isEmpty()){
                Toast.makeText(
                    this,
                    "Error! Type a CPF to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val dbHelper = MyDatabaseHelper(this)
            val writableInstance = dbHelper.writableDatabase

            val rowsAffected = writableInstance.delete(
                MyDatabaseHelper.CUSTOMER_TABLE_NAME,
                "${MyDatabaseHelper.CUSTOMER_COLUMN_CPF} = ?",
                arrayOf(cpfEditText.text.toString())
            )

            if (rowsAffected < 1) {
                Toast.makeText(
                    this,
                    "Something was wrong :(, your customer wasn't deleted on the database",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "The customer has been successfully deleted!",
                    Toast.LENGTH_SHORT
                ).show()

                this.finish()
            }
        }
    }
}