package com.example.chocolatestorage

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChocolateEditScreen : AppCompatActivity() {
    lateinit var chocolateIdEditText: EditText
    lateinit var amountCocoaEditText: EditText
    lateinit var chocolateColorRadioGroup: RadioGroup
    lateinit var chocolatePriceEditText: EditText

    lateinit var cancelButton: Button
    lateinit var editChocolateButton: Button
    lateinit var findChocolateButton: Button

    private var chocolateToEdition: Chocolate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chocolate_edit_screen)

        chocolateIdEditText = findViewById(R.id.et_chocolateId2)
        amountCocoaEditText = findViewById(R.id.et_amountCocoa2)
        chocolateColorRadioGroup = findViewById(R.id.rg_chocolateColor2)
        chocolatePriceEditText = findViewById(R.id.et_chocolatePrice2)

        cancelButton = findViewById(R.id.btn_cancelChocolateEditScreen)
        editChocolateButton = findViewById(R.id.btn_editChocolate)
        findChocolateButton = findViewById(R.id.btn_findChocolateToEdit)

        cancelButton.setOnClickListener {
            this.finish()
        }

        val dbHelper = MyDatabaseHelper(this)

        findChocolateButton.setOnClickListener {
            if (chocolateIdEditText.text.isEmpty()){
                Toast.makeText(
                    this,
                    "Error! Type a Chocolate ID to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val chocolateList = ChocolateDbUtils.getAllChocolates(dbHelper)
            val chocolate = chocolateList.find {
                    c -> c.id.equals(chocolateIdEditText.text.toString())
            }

            chocolateToEdition = chocolate

            if (chocolate == null){
                Toast.makeText(
                    this,
                    "Error! The chocolate doesn't exists, check if the ID was typed correctly!",
                    Toast.LENGTH_SHORT
                ).show()

                chocolateIdEditText.text.clear()
                amountCocoaEditText.text.clear()
                chocolatePriceEditText.text.clear()

                return@setOnClickListener
            }

            chocolateIdEditText.setText(chocolate.id)
            amountCocoaEditText.setText(chocolate.amountCocoa.toString())
            chocolateColorRadioGroup.check(if (chocolate.color == "Black") R.id.rb_chocolateBlack2 else R.id.rb_chocolateWhite2)
            chocolatePriceEditText.setText(chocolate.price.toString())
        }

        editChocolateButton.setOnClickListener {
            if (chocolateToEdition == null){
                Toast.makeText(
                    this,
                    "Error! Type a Chocolate ID to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val writableInstance = dbHelper.writableDatabase
            val contentValues = ContentValues().apply {
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_ID, chocolateToEdition?.id)
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_AMOUNT_COCOA, amountCocoaEditText.text.toString())
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_COLOR, getChocolateColor(chocolateColorRadioGroup))
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_PRICE, chocolatePriceEditText.text.toString())
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_CUSTOMER_CPF, chocolateToEdition?.customerCpf)
            }

            val rowIndex = writableInstance.update(MyDatabaseHelper.CHOCOLATE_TABLE_NAME, contentValues, "${MyDatabaseHelper.CHOCOLATE_COLUMN_ID} = ?", arrayOf(chocolateToEdition?.id))
            if (rowIndex < 1){
                Toast.makeText(
                    this,
                    "Something was wrong :(, your chocolate wasn't edited on the database",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "The chocolate has been successfully edited!",
                    Toast.LENGTH_SHORT
                ).show()

                chocolateIdEditText.text.clear()
                amountCocoaEditText.text.clear()
                chocolatePriceEditText.text.clear()

                this.finish()
            }
        }
    }

    private fun getChocolateColor(chocolateColorRadioGroup: RadioGroup) : String {
        when(chocolateColorRadioGroup.checkedRadioButtonId){
            R.id.rb_chocolateBlack2 -> return "Black"
            R.id.rb_chocolateWhite2 -> return "White"
        }

        return "Chocolate with new COLOR"
    }
}
