package com.example.computermanagement

import android.os.Bundle
import android.widget.ArrayAdapter
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
        CustomerCountTextView.text = customerList.count().toString()

        // 3. Find customer by email
        SearchCustomerByEmail.setOnClickListener {
            CustomerByEmailResultTextView.text = "No customers found..."

            for (customer in customerList){
                if (customer.getEmail().equals(EmailToSearchEditText.text.toString())){
                    CustomerByEmailResultTextView.text = customer.toString()
                }
            }
        }

        // 4. Find customers by computer model
        SearchCustomersByComputerModel.setOnClickListener {
            val customersWithComputerTarget = ArrayList<String>()
            for (customer in customerList){
                if (customer.getComputerModel().equals(ComputerModelToSearchEditText.text.toString())){
                    customersWithComputerTarget.add(customer.toString())
                }
            }

            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, customersWithComputerTarget)
            CustomersByComputerModelListView.adapter = arrayAdapter
        }

        GoBackButton.setOnClickListener {
            this.finish()
        }
    }
}