package com.example.chocolatestorage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class HomeScreen : AppCompatActivity() {
    lateinit var goCustomerRecordButton: Button

    lateinit var customerSectionRadioGroup: RadioGroup
    lateinit var executeCustomerSectionButton: Button

    lateinit var chocolateSectionRadioGroup: RadioGroup
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
            goToScreen(CustomerRecordScreen())
        }

        executeCustomerSectionButton.setOnClickListener {
            when(customerSectionRadioGroup.checkedRadioButtonId){
                R.id.rb_showAllCustomers -> goToScreen(ShowAllCustomersScreen())
                R.id.rb_editCustomer -> Log.i("TEST-DEV", "Edit customer")
                R.id.btn_executeCustomerSection -> Log.i("TEST-DEV", "Delete Customer")
            }
        }

        executeChocolateSectionButton.setOnClickListener {
            when(chocolateSectionRadioGroup.checkedRadioButtonId){
                R.id.rb_showAllChocolates -> Log.i("TEST-DEV", "Show All Chocolates")
                R.id.rb_editChocolates -> Log.i("TEST-DEV", "Edit chocolate")
                R.id.rb_deleteChocolate -> Log.i("TEST-DEV", "Delete chocolate")
            }
        }

        goCustomersSearchButton.setOnClickListener {
        }

        goChocolateSearchButton.setOnClickListener {
        }
    }

    private fun goToScreen(screenTarget: AppCompatActivity){
        val intent = Intent(this, screenTarget::class.java)
        this.startActivity(intent)
    }
}