package com.example.learningcomponents

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var cpfInput : EditText
    lateinit var nameInput : EditText
    lateinit var destinationsSpinner : Spinner
    lateinit var travelModeRadioGroup : RadioGroup
    lateinit var carRadioButton : RadioButton
    lateinit var busRadioButton : RadioButton
    lateinit var airplaneRadioButton : RadioButton
    lateinit var paymentModeRadioGroup : RadioGroup
    lateinit var debitCardRadioButton : RadioButton
    lateinit var creditCardRadioButton : RadioButton
    lateinit var pixRadioButton : RadioButton
    lateinit var travelInsuranceCheckBox : CheckBox
    lateinit var rentCarCheckBox : CheckBox
    lateinit var bookTripButton : Button
    lateinit var reservationsListView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Binding components
        cpfInput = findViewById(R.id.et_cpf)
        nameInput = findViewById(R.id.et_name)
        destinationsSpinner = findViewById(R.id.sp_destinations)
        travelModeRadioGroup = findViewById(R.id.rg_travelmode)
        carRadioButton = findViewById(R.id.rb_car)
        busRadioButton = findViewById(R.id.rb_bus)
        airplaneRadioButton = findViewById(R.id.rb_airplane)
        paymentModeRadioGroup = findViewById(R.id.rb_paymentmode)
        debitCardRadioButton = findViewById(R.id.rb_debitCard)
        creditCardRadioButton = findViewById(R.id.rb_creditCard)
        pixRadioButton = findViewById(R.id.rb_pix)
        travelInsuranceCheckBox = findViewById(R.id.cb_insurance)
        rentCarCheckBox = findViewById(R.id.cb_rentCar)
        bookTripButton = findViewById(R.id.btn_bookTrip)
        reservationsListView = findViewById(R.id.lv_reservations)

        var destinationList = ArrayList<String>()
        destinationList.add("Rio de Janeiro")
        destinationList.add("Foz do Iguaçu")
        destinationList.add("Monte Verde")
        destinationList.add("Campos do Jordão")

        var destinationAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            destinationList
        )

        destinationsSpinner.adapter = destinationAdapter

        var reservationsList = ArrayList<String>()
        var reservationsAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            reservationsList
        )
        reservationsListView.adapter = reservationsAdapter;

        bookTripButton.setOnClickListener {
            var destinationSelected = destinationsSpinner.selectedItem.toString()

            var travelModeSelected = "";
            when (travelModeRadioGroup.checkedRadioButtonId){
                carRadioButton.id -> travelModeSelected =  "I'll with car"
                busRadioButton.id -> travelModeSelected =  "I'll with bus"
                airplaneRadioButton.id -> travelModeSelected =  "I'll with airplane"
            }

            var paymentModelSelected = "";
            when(paymentModeRadioGroup.checkedRadioButtonId){
                debitCardRadioButton.id -> paymentModelSelected = "I've a lot of money bro"
                creditCardRadioButton.id -> paymentModelSelected = "I'm a poor, sorry :/"
                pixRadioButton.id -> paymentModelSelected = "I'm brazilian!"
            }

            var travelInsuranceValue = if (travelInsuranceCheckBox.isChecked) "I want insurance" else "I don't want insurance"
            var rentCarValue = if (rentCarCheckBox.isChecked) "I want rent a car please" else "I'm a richest person man, I don't need rent anything"

            var person = Person(cpf = cpfInput.text.toString(), name = nameInput.text.toString())

            var reservationResult = "- $destinationSelected" +
                    "\n- $travelModeSelected" +
                    "\n- $paymentModelSelected" +
                    "\n- $travelInsuranceValue" +
                    "\n- $rentCarValue" +
                    "\n The reservation is for ${person.name} with CPF ${person.cpf}"
            reservationsList.add(reservationResult)
            reservationsListView.adapter = reservationsAdapter

            cpfInput.text.clear();
            nameInput.text.clear();
        }
    }
}