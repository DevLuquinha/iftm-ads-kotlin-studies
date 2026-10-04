package com.example.chocolatestorage

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