package com.example.computermanagement

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomerSearchScreen : AppCompatActivity() {
    lateinit var CustomerCountTextView: TextView
    lateinit var EmailToSearchEditText: EditText
    lateinit var SearchCustomerByEmail: Button
    lateinit var CustomerByEmailResultTextView: TextView
    lateinit var ComputerModelToSearchEditText: EditText
    lateinit var SearchCustomersByComputerModel: Button
    lateinit var CustomersByComputerModelListView: ListView
    lateinit var GoBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_search_screen)

        CustomerCountTextView = findViewById(R.id.tv_customerCount)
        EmailToSearchEditText = findViewById(R.id.et_emailToSearch)
        SearchCustomerByEmail = findViewById(R.id.btn_searchCustomerByEmail)
        CustomerByEmailResultTextView = findViewById(R.id.tv_customerByEmail)
        ComputerModelToSearchEditText = findViewById(R.id.et_computerModelToSearch)
        SearchCustomersByComputerModel = findViewById(R.id.btn_searchCustomersByComputerModel)
        CustomersByComputerModelListView = findViewById(R.id.lv_customersByComputerModel)
        GoBackButton = findViewById(R.id.btn_goBack)

        GoBackButton.setOnClickListener {
            this.finish()
        }
    }
}