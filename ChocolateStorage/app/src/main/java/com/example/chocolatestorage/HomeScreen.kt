package com.example.chocolatestorage

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group

class HomeScreen : AppCompatActivity() {
    lateinit var goCustomerRecordButton: Button

    lateinit var customerSectionRadioGroup: RadioGroup
    lateinit var selectedCustomerSectionRadioButton: RadioButton
    lateinit var executeCustomerSectionButton: Button

    lateinit var chocolateSectionRadioGroup: RadioGroup
    lateinit var selectedChocolateSectionRadioButton: RadioButton
    lateinit var executeChocolateSectionButton: Button

    lateinit var goCustomersSearchButton: Button
    lateinit var goChocolateSearchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        // Binding UI components
        goCustomerRecordButton = findViewById(R.id.btn_goCustomerRecord)
        customerSectionRadioGroup = findViewById(R.id.rg_customerSection)
        executeCustomerSectionButton = findViewById(R.id.btn_executeCustomerSection)

        chocolateSectionRadioGroup = findViewById(R.id.rg_chocolateSection)
        executeChocolateSectionButton = findViewById(R.id.btn_executeChocolateSection)

        goCustomersSearchButton = findViewById(R.id.btn_goCustomerSearch)
        goChocolateSearchButton = findViewById(R.id.btn_goChocolateSearch)

        goCustomerRecordButton.setOnClickListener {
            Log.i("TEST-DEV", "1")
        }

        executeCustomerSectionButton.setOnClickListener {
            Log.i("TEST-DEV", "2")
            when(customerSectionRadioGroup.checkedRadioButtonId){
                R.id.rb_showAllCustomers -> Log.i("TEST-DEV", "Show All Customers")
                R.id.rb_editCustomer -> Log.i("TEST-DEV", "Edit customer")
                R.id.rb_deleteCustomer -> Log.i("TEST-DEV", "Delete Customer")
            }
        }

        executeChocolateSectionButton.setOnClickListener {
            Log.i("TEST-DEV", "3")
            when(chocolateSectionRadioGroup.checkedRadioButtonId){
                R.id.rb_showAllChocolates -> Log.i("TEST-DEV", "Show All Chocolates")
                R.id.rb_editChocolates -> Log.i("TEST-DEV", "Edit chocolate")
                R.id.rb_deleteChocolate -> Log.i("TEST-DEV", "Delete chocolate")
            }
        }

        goCustomersSearchButton.setOnClickListener {
            Log.i("TEST-DEV", "4")
        }

        goChocolateSearchButton.setOnClickListener {
            Log.i("TEST-DEV", "5")
        }
    }
}