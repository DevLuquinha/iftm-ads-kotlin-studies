package com.example.listexercises

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var cpfInput : EditText;
    lateinit var nameInput : EditText;
    lateinit var ageInput : EditText;
    lateinit var addPersonButton : Button;
    lateinit var peopleListView : ListView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cpfInput = findViewById(R.id.et_cpf);
        nameInput = findViewById(R.id.et_name);
        ageInput = findViewById(R.id.et_age);
        addPersonButton = findViewById(R.id.btn_addPerson);
        peopleListView = findViewById(R.id.lv_people);

        var peopleList = ArrayList<String>();
        var peopleAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, peopleList);
        peopleListView.adapter = peopleAdapter;

        addPersonButton.setOnClickListener {
            var person = Person(
                cpf = cpfInput.text.toString(),
                name = nameInput.text.toString(),
                age = ageInput.text.toString().toInt()
            );

            peopleList.add(person.toString());
            peopleListView.adapter = peopleAdapter;

            cpfInput.text.clear();
            nameInput.text.clear();
            ageInput.text.clear();
        }
    }
}