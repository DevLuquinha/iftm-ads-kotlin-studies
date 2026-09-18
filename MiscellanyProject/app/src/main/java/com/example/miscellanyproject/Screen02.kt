package com.example.miscellanyproject

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Screen02 : AppCompatActivity() {
    lateinit var backScreenButton : Button
    lateinit var studentListView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_02)

        backScreenButton = findViewById(R.id.btn_back)
        studentListView = findViewById(R.id.lv_student)

        val screen01Data = intent.extras
        val academicRecord = screen01Data?.getString("123")
        val studentName = screen01Data?.getString("456")
        val period = screen01Data?.getInt("789")
        val pdmGrade = screen01Data?.getDouble("321")

        val listGeneral = ArrayList<String>()
        listGeneral.add("AR: $academicRecord | NAME: $studentName | PERIOD: $period | PDM GRADE: $pdmGrade")
        val listGeneralArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listGeneral)

        studentListView.adapter = listGeneralArrayAdapter
        
        backScreenButton.setOnClickListener {
            this.finish()
        }
    }
}