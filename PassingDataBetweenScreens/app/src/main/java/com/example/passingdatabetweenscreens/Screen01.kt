package com.example.passingdatabetweenscreens

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Screen01 : AppCompatActivity() {
    lateinit var academicRecordEditText : EditText
    lateinit var studentNameEditText : EditText
    lateinit var studentAgeEditText : EditText
    lateinit var coursesRadioGroup : RadioGroup
    lateinit var systemAnalysisDevelopmentRadioButton : RadioButton
    lateinit var computerEngineerRadioButton : RadioButton
    lateinit var bachelorsDegreeMathRadioButton : RadioButton
    lateinit var residentUberabaCheckBox : CheckBox
    lateinit var addStudentButton : Button
    lateinit var showStudentsButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_01)

        academicRecordEditText = findViewById(R.id.et_academicRecord)
        studentNameEditText = findViewById(R.id.et_studentName)
        studentAgeEditText = findViewById(R.id.et_studentAge)
        coursesRadioGroup = findViewById(R.id.rg_courses)
        systemAnalysisDevelopmentRadioButton = findViewById(R.id.rb_systemAnalysisDevelopment)
        computerEngineerRadioButton = findViewById(R.id.rb_computerEngineer)
        bachelorsDegreeMathRadioButton = findViewById(R.id.rb_bachelorsDegreeMath)
        residentUberabaCheckBox = findViewById(R.id.cb_residentUberaba)
        addStudentButton = findViewById(R.id.btn_addStudent)
        showStudentsButton = findViewById(R.id.btn_showStudents)

        addStudentButton.setOnClickListener {
            val newStudent = Student(
                academicRecordEditText.text.toString(),
                studentNameEditText.text.toString(),
                studentAgeEditText.text.toString().toInt(),
                getCourseSelected(),
                residentUberabaCheckBox.isChecked
            );

            val dataLoader = Bundle()
            dataLoader.putParcelable("NEW_STUDENT", newStudent)

            val switchScreenIntent = Intent(this, Screen02::class.java)
            switchScreenIntent.putExtras(dataLoader)

            val dbHelper = MyDatabaseHelper(this)
            val writableDatabaseInstance = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("academic_record", newStudent.academicRecord)
                put("name", newStudent.name)
                put("age", newStudent.age)
                put("course_name", newStudent.courseName)
                put("is_resident_uberaba", newStudent.isResidentUberaba)
            }

            val newRowId = writableDatabaseInstance.insert("students", null, values)

            Toast.makeText(this, newRowId.toString(), Toast.LENGTH_SHORT).show()
        }

        showStudentsButton.setOnClickListener {
            val switchScreenIntent = Intent(this, Screen02::class.java)
            this.startActivity(switchScreenIntent)
        }
    }

    private fun getCourseSelected() : String {
        when(coursesRadioGroup.checkedRadioButtonId){
            systemAnalysisDevelopmentRadioButton.id -> return "System Analysis Development"
            computerEngineerRadioButton.id -> return "Computer Engineer"
            bachelorsDegreeMathRadioButton.id -> return "Bachelors Degree Math"
        }

        return "Any course was selected"
    }
}