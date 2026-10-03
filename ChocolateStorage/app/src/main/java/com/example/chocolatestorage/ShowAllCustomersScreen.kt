package com.example.chocolatestorage

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShowAllCustomersScreen : AppCompatActivity() {
    lateinit var customersTotalTextView: TextView
    lateinit var customersListView: ListView
    lateinit var goHomeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_all_customers_screen)

        customersTotalTextView = findViewById(R.id.tv_customersCount)
        customersListView = findViewById(R.id.lv_customers)
        goHomeButton = findViewById(R.id.btn_showAllCustomersToHome)

        goHomeButton.setOnClickListener {
            this.finish()
        }

        val dbHelper = MyDatabaseHelper(this)
        val allCustomers = DatabaseUtils.getAllCustomers(dbHelper)
        val customersCount = allCustomers.count()

        customersTotalTextView.text = customersCount.toString()

        if (customersCount > 0){
            val customersList = ArrayList<String>()
            for (customer in allCustomers){
                customersList.add(customer.name)
            }

            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, customersList)
            customersListView.adapter = arrayAdapter
        }
    }
}