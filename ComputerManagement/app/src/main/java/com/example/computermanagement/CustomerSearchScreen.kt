package com.example.computermanagement

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CustomerSearchScreen : AppCompatActivity() {
    lateinit var customerCountTextView: TextView
    lateinit var emailToSearchEditText: EditText
    lateinit var searchCustomerByEmail: Button
    lateinit var customerByEmailResultTextView: TextView
    lateinit var computerModelToSearchEditText: EditText
    lateinit var searchCustomersByComputerModel: Button
    lateinit var customersByComputerModelListView: ListView
    lateinit var goBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_search_screen)

        customerCountTextView = findViewById(R.id.tv_customerCount)
        emailToSearchEditText = findViewById(R.id.et_emailToSearch)
        searchCustomerByEmail = findViewById(R.id.btn_searchCustomerByEmail)
        customerByEmailResultTextView = findViewById(R.id.tv_customerByEmail)
        computerModelToSearchEditText = findViewById(R.id.et_computerModelToSearch)
        searchCustomersByComputerModel = findViewById(R.id.btn_searchCustomersByComputerModel)
        customersByComputerModelListView = findViewById(R.id.lv_customersByComputerModel)
        goBackButton = findViewById(R.id.btn_goBack)

        // 1. Get all customer from db
        val customerList = ArrayList<Customer>()
        val dbHelper = MyDatabaseHelper(this)
        val readableDbInstance = dbHelper.readableDatabase
        var resultCursor = readableDbInstance.rawQuery("SELECT * FROM ${MyDatabaseHelper.TABLE_NAME}", null)

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

        // 2. Update the customer count in view
        customerCountTextView.text = customerList.count().toString()

        // 3. Find customer by email
        searchCustomerByEmail.setOnClickListener {
            customerByEmailResultTextView.text = "No customers found..."

            for (customer in customerList){
                if (customer.getEmail().equals(emailToSearchEditText.text.toString())){
                    customerByEmailResultTextView.text = customer.toString()
                }
            }
        }

        // 4. Find customers by computer model
        searchCustomersByComputerModel.setOnClickListener {
            val customersWithComputerTarget = ArrayList<String>()
            for (customer in customerList){
                if (customer.getComputerModel().equals(computerModelToSearchEditText.text.toString())){
                    customersWithComputerTarget.add(customer.toString())
                }
            }

            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, customersWithComputerTarget)
            customersByComputerModelListView.adapter = arrayAdapter
        }

        goBackButton.setOnClickListener {
            this.finish()
        }
    }
}