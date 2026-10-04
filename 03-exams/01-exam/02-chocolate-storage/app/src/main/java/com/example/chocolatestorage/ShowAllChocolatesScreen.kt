package com.example.chocolatestorage

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowAllChocolatesScreen : AppCompatActivity() {
    lateinit var chocolatesTotalTextView: TextView
    lateinit var chocolatesListView: ListView
    lateinit var goHomeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_all_chocolates_screen)

        chocolatesTotalTextView = findViewById(R.id.tv_chocolatesCount)
        chocolatesListView = findViewById(R.id.lv_chocolates)
        goHomeButton = findViewById(R.id.btn_showAllChocolatesToHome)

        goHomeButton.setOnClickListener {
            this.finish()
        }

        val dbHelper = MyDatabaseHelper(this)
        val allChocolates = ChocolateDbUtils.getAllChocolates(dbHelper)
        val chocolateCount = allChocolates.count()

        chocolatesTotalTextView.text = chocolateCount.toString()

        if (chocolateCount > 0){
            val chocolatesList = ArrayList<String>()
            for (chocolate in allChocolates){
                chocolatesList.add(chocolate.id)
            }

            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chocolatesList)
            chocolatesListView.adapter = arrayAdapter
        }
    }
}
