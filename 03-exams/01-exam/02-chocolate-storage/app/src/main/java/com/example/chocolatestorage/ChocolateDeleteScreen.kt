package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChocolateDeleteScreen : AppCompatActivity() {
    lateinit var chocolateIdEditText: EditText
    lateinit var cancelButton: Button
    lateinit var deleteChocolateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chocolate_delete_screen)

        chocolateIdEditText = findViewById(R.id.et_chocolateId3)
        cancelButton = findViewById(R.id.btn_cancelChocolateDeleteScreen)
        deleteChocolateButton = findViewById(R.id.btn_deleteChocolate)

        cancelButton.setOnClickListener {
            this.finish()
        }

        deleteChocolateButton.setOnClickListener {
            if (chocolateIdEditText.text.isEmpty()){
                Toast.makeText(
                    this,
                    "Error! Type a CHOCOLATE ID to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val dbHelper = MyDatabaseHelper(this)
            val writableInstance = dbHelper.writableDatabase

            val rowsAffected = writableInstance.delete(
                MyDatabaseHelper.CHOCOLATE_TABLE_NAME,
                "${MyDatabaseHelper.CHOCOLATE_COLUMN_ID} = ?",
                arrayOf(chocolateIdEditText.text.toString())
            )

            if (rowsAffected < 1) {
                Toast.makeText(
                    this,
                    "Something was wrong :(, your chocolate wasn't deleted on the database",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "The chocolate has been successfully deleted!",
                    Toast.LENGTH_SHORT
                ).show()

                this.finish()
            }
        }
    }
}
