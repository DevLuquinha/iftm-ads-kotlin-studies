package com.example.chocolatestorage

import android.os.Bundle
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
    }
}
