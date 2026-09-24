package com.example.passingdatabetweenscreens

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Screen02 : AppCompatActivity() {
    lateinit var studentsListView : ListView
    lateinit var goBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_02)

        studentsListView = findViewById(R.id.lv_students)
        goBackButton = findViewById(R.id.btn_goBack)

        val screen01Data = intent.extras
        val newStudent = screen01Data?.getParcelable("NEW_STUDENT", Student::class.java);

        val studentList = ArrayList<String>()
        studentList.add(newStudent.toString())
        val studentsArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentList)

        studentsListView.adapter = studentsArrayAdapter

        val dbHelper = MyDatabaseHelper(this)
        val db = dbHelper.readableDatabase
        val dbResult = db.rawQuery("SELECT * FROM students", null)

        goBackButton.setOnClickListener {
            this.finish()
        }
    }
}