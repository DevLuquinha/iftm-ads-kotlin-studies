package com.example.chocolatestorage

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChocolateSearchScreen : AppCompatActivity() {
    lateinit var chocolateIdEditText: EditText
    lateinit var searchChocolateButton: Button
    lateinit var searchChocolateResultTextView: TextView
    lateinit var mostExpensiveChocolateTextView: TextView
    lateinit var averageChocolatePriceTextView: TextView
    lateinit var chocolatesAboveFiftyCocoaListView: ListView
    lateinit var goBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chocolate_search_screen)

        chocolateIdEditText = findViewById(R.id.et_chocolateId4)
        searchChocolateButton = findViewById(R.id.btn_searchChocolate)
        searchChocolateResultTextView = findViewById(R.id.tv_searchChocolateResult)
        mostExpensiveChocolateTextView = findViewById(R.id.tv_mostExpensiveChocolate)
        averageChocolatePriceTextView = findViewById(R.id.tv_averageChocolatePrice)
        chocolatesAboveFiftyCocoaListView = findViewById(R.id.lv_chocolatesAboveFiftyCocoa)
        goBackButton = findViewById(R.id.btn_chocolateSearchToHome)

        val dbHelper = MyDatabaseHelper(this)
        val allChocolatesList = ChocolateDbUtils.getAllChocolates(dbHelper)

        if (!allChocolatesList.isEmpty()){
            // 1. Most Expensive Chocolate
            val chocolateExpensive = allChocolatesList.maxByOrNull {
                it.price
            }

            if (chocolateExpensive != null){
                mostExpensiveChocolateTextView.text = "${chocolateExpensive.id} with R$${chocolateExpensive.price}"
            }

            // 2. Average chocolate price
            val averagePrice = allChocolatesList.sumOf { it.price } / allChocolatesList.size
            averageChocolatePriceTextView.text = "R$" + "%.2f".format(averagePrice)

            // 3. Chocolates Above 50% Cocoa
            val chocolatesAboveList = ArrayList<String>()
            for (chocolate in allChocolatesList){
                if (chocolate.amountCocoa > 50){
                    chocolatesAboveList.add(chocolate.toString())
                }
            }
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chocolatesAboveList)
            chocolatesAboveFiftyCocoaListView.adapter = arrayAdapter
        }

        goBackButton.setOnClickListener {
            finish()
        }

        searchChocolateButton.setOnClickListener {
            if (chocolateIdEditText.text.isEmpty()){
                Toast.makeText(
                    this,
                    "Error! Type a CHOCOLATE ID to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val dbHelper = MyDatabaseHelper(this)
            val allChocolatesList = ChocolateDbUtils.getAllChocolates(dbHelper)
            val chocolate = allChocolatesList.find {
                    c -> c.id.equals(chocolateIdEditText.text.toString())
            }

            if (chocolate == null){
                Toast.makeText(
                    this,
                    "Error! The chocolate doesn't exists, check if the ID was typed correctly!",
                    Toast.LENGTH_SHORT
                ).show()

                searchChocolateResultTextView.text = "Error! The chocolate doesn't exists, check if the ID was typed correctly!"
                return@setOnClickListener
            }

            searchChocolateResultTextView.text = chocolate.toString()
        }
    }
}
