package com.example.chocolatestorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
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

        goBackButton.setOnClickListener {
            finish()
        }

        searchChocolateButton.setOnClickListener {
        }
    }
}
