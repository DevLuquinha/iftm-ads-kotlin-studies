package com.example.passingdatabetweenscreens

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity

class Screen02 : AppCompatActivity() {
    lateinit var studentsListView : ListView
    lateinit var goBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_02)

        studentsListView = findViewById(R.id.lv_students)
        goBackButton = findViewById(R.id.btn_goBack)

        val studentList = ArrayList<String>()

        val dbHelper = MyDatabaseHelper(this)
        val readableDatabaseInstance = dbHelper.readableDatabase
        val dbResultCursor = readableDatabaseInstance.rawQuery("SELECT * FROM students", null)

        with(dbResultCursor){ // Rows and Columns
            while (moveToNext()){  // Iterate row by row
                val academicRecord = getString(getColumnIndexOrThrow("academic_record"))
                val name = getString(getColumnIndexOrThrow("name"))
                val age = getInt(getColumnIndexOrThrow("age"))
                val courseName = getString(getColumnIndexOrThrow("course_name"))
                val isResidentUberaba = getInt(getColumnIndexOrThrow("is_resident_uberaba"))
                val newStudent = Student(academicRecord, name, age, courseName, isResidentUberaba == 1)
                studentList.add(newStudent.toString())
            }
        }

        // Old implementation
//        val screen01Data = intent.extras
//        val newStudent = screen01Data?.getParcelable("NEW_STUDENT", Student::class.java);
        val studentsArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentList)
        studentsListView.adapter = studentsArrayAdapter

        goBackButton.setOnClickListener {
            this.finish()
        }
    }
}