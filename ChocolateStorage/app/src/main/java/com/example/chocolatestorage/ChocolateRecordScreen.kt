package com.example.chocolatestorage

import android.content.ContentValues
import android.content.Intent
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
import org.w3c.dom.Text

class ChocolateRecordScreen : AppCompatActivity() {
    lateinit var chocolateIdEditText: EditText
    lateinit var amountCocoaEditText: EditText
    lateinit var chocolateColorRadioGroup: RadioGroup
    lateinit var chocolatePriceEditText: EditText
    lateinit var cancelButton: Button
    lateinit var createChocolateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chocolate_record_screen)

        chocolateIdEditText = findViewById(R.id.et_chocolateId)
        amountCocoaEditText = findViewById(R.id.et_amountCocoa)
        chocolateColorRadioGroup = findViewById(R.id.rg_chocolateColor)
        chocolatePriceEditText = findViewById(R.id.et_chocolatePrice)
        cancelButton = findViewById(R.id.btn_cancelChocolateRecordScreen)
        createChocolateButton = findViewById(R.id.btn_createChocolate)

        cancelButton.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }

        createChocolateButton.setOnClickListener {
            val chocolateId = chocolateIdEditText.text.toString()
            val chocolatePrice = chocolatePriceEditText.text.toString().toDouble()
            val chocolateColor = getChocolateColor(chocolateColorRadioGroup)
            val amountOfCocoa = amountCocoaEditText.text.toString().toInt()
            if (amountOfCocoa !in 20..90){
                Toast.makeText(
                    this,
                    "Error! Amount of cocoa must be between 20% and 90%!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val customerRecordScreenData = intent.extras
            val customerCpf = customerRecordScreenData?.getString("CUSTOMER_CPF")
            if (customerCpf == null){
                Toast.makeText(
                    this,
                    "Something was wrong :(, customer cpf not found!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val chocolate = Chocolate(
                chocolateId,
                amountOfCocoa,
                chocolateColor,
                chocolatePrice,
                customerCpf
            )

            Log.i("TEST-DEV", chocolate.toString())
            val dbHelper = MyDatabaseHelper(this)
            val writableInstance = dbHelper.writableDatabase

            val contentValues = ContentValues().apply {
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_ID, chocolate.id)
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_AMOUNT_COCOA, chocolate.amountCocoa)
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_COLOR, chocolate.color)
                put(MyDatabaseHelper.CHOCOLATE_COLUMN_PRICE, chocolate.price)
                put(MyDatabaseHelper.CUSTOMER_COLUMN_CPF, chocolate.customerCpf)
            }

            val rowId = writableInstance.insert(MyDatabaseHelper.CHOCOLATE_TABLE_NAME, null, contentValues)
            if (rowId == -1L){
                Toast.makeText(
                    this,
                    "Something was wrong :(, your chocolate wasn't added on the database",
                    Toast.LENGTH_SHORT
                ).show()

                Log.i("ERROR-DEBUG", "ChocolateRecordScreen throws the error $rowId")

                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "The customer has been successfully added!",
                Toast.LENGTH_SHORT
            ).show()

            chocolateIdEditText.text.clear()
            amountCocoaEditText.text.clear()
            chocolatePriceEditText.text.clear()

            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
    }

    private fun getChocolateColor(chocolateColorRadioGroup: RadioGroup) : String {
        when(chocolateColorRadioGroup.checkedRadioButtonId){
            R.id.rb_chocolateBlack -> return "Black"
            R.id.rb_chocolateWhite -> return "White"
        }

        return "Chocolate with new COLOR"
    }

}