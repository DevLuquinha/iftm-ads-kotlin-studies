package com.example.computermanagement

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeScreen : AppCompatActivity() {
    lateinit var customerActionsRadioGroup : RadioGroup
    lateinit var selectedActionRadioButton : RadioButton
    lateinit var executeActionButton : Button
    lateinit var showComputersByPriceButton : Button
    lateinit var averageSalesByAmountButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        customerActionsRadioGroup = findViewById(R.id.rg_customerActions)
        selectedActionRadioButton = findViewById(customerActionsRadioGroup.checkedRadioButtonId)
        executeActionButton = findViewById(R.id.btn_execute)
        showComputersByPriceButton = findViewById(R.id.btn_showComputersByPrice)
        averageSalesByAmountButton = findViewById(R.id.btn_averageSalesAmount)

        executeActionButton.setOnClickListener {
            selectedActionRadioButton = findViewById(customerActionsRadioGroup.checkedRadioButtonId)
            if (selectedActionRadioButton.text.equals("Record a customer")){
                val goToCustomerRecordScreenIntent = Intent(this, CustomerRecordScreen::class.java)
                this.startActivity(goToCustomerRecordScreenIntent)
            } else if (selectedActionRadioButton.text.equals("Customer search")){
                val goToCustomerSearchScreenIntent = Intent(this, CustomerSearchScreen::class.java)
                this.startActivity(goToCustomerSearchScreenIntent)
            }
        }
    }
}