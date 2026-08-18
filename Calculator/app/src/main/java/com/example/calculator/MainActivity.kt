package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textViewTotal: TextView
    lateinit var textViewPreview: TextView
    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button

    lateinit var equalsButton: Button
    lateinit var sumButton: Button
    lateinit var minusButton: Button
    lateinit var multButton: Button
    lateinit var diviButton: Button
    lateinit var backspaceButton: Button
    lateinit var commaButton: Button

    lateinit var fractionButton: Button
    lateinit var powButton: Button
    lateinit var sqrtButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get values from View
        textViewPreview = findViewById(R.id.tv_preview)
        textViewTotal = findViewById(R.id.tv_total)
        button0 = findViewById(R.id.btn_0)
        button1 = findViewById(R.id.btn_1)
        button2 = findViewById(R.id.btn_2)
        button3 = findViewById(R.id.btn_3)
        button4 = findViewById(R.id.btn_4)
        button5 = findViewById(R.id.btn_5)
        button6 = findViewById(R.id.btn_6)
        button7 = findViewById(R.id.btn_7)
        button8 = findViewById(R.id.btn_8)
        button9 = findViewById(R.id.btn_9)

        equalsButton = findViewById(R.id.btn_equal)
        sumButton = findViewById(R.id.btn_sum)
        minusButton = findViewById(R.id.btn_minus)
        multButton = findViewById(R.id.btn_mult)
        diviButton = findViewById(R.id.btn_divi)
        backspaceButton = findViewById(R.id.btn_backspace)
        commaButton = findViewById(R.id.btn_comma)

        fractionButton = findViewById(R.id.btn_fraction)
        powButton = findViewById(R.id.btn_pow)
        sqrtButton = findViewById(R.id.btn_sqrt)

        var currentTotal : Double = 0.0;
        var currentOperation = "";
        var secondNumber = 0.0;

        backspaceButton.setOnClickListener {
            if (textViewTotal.text.length > 0) {
                textViewTotal.text = textViewTotal.text.toString().dropLast(1)
            }

            if (textViewTotal.text.length == 0) {
                textViewTotal.text = "0"
            }
        }

        button0.setOnClickListener {
            if (textViewTotal.text.toString() != "0") {
                textViewTotal.text = textViewTotal.text.toString() + "0"
            }
        }

        button1.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "1"
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "1"
            }
        }

        button2.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "2"
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "2"
            }
        }

        button3.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "3";
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "3";
            }
        }

        button4.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "4";
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "4";
            }
        }

        button5.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "5";
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "5";
            }
        }

        button6.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "6";
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "6";
            }
        }

        button7.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "7";
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "7";
            }
        }

        button8.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "8";
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "8";
            }
        }

        button9.setOnClickListener {
            if (textViewTotal.text.toString() == "0") {
                textViewTotal.text = "9";
            } else {
                textViewTotal.text = textViewTotal.text.toString() + "9";
            }
        }

        commaButton.setOnClickListener {
            if (!textViewTotal.text.toString().contains(".")){
                textViewTotal.text = textViewTotal.text.toString() + "."
            }
        }

        sumButton.setOnClickListener {
            currentTotal = textViewTotal.text.toString().toDouble();

            textViewPreview.text = textViewTotal.text.toString() + " + "
            textViewTotal.text = "0";
            currentOperation = "+";
        }

        minusButton.setOnClickListener {
            currentTotal = textViewTotal.text.toString().toDouble();

            textViewPreview.text = textViewTotal.text.toString() + " - "
            textViewTotal.text = "0";
            currentOperation = "-";
        }

        multButton.setOnClickListener {
            currentTotal = textViewTotal.text.toString().toDouble();

            textViewPreview.text = textViewTotal.text.toString() + " x "
            textViewTotal.text = "0";
            currentOperation = "x";
        }

        diviButton.setOnClickListener {
            currentTotal = textViewTotal.text.toString().toDouble();

            textViewPreview.text = textViewTotal.text.toString() + " / "
            textViewTotal.text = "0";
            currentOperation = "/";
        }

        fractionButton.setOnClickListener {
            currentTotal = textViewTotal.text.toString().toDouble();
            textViewTotal.text =  (1.0 / currentTotal).toString();
            textViewPreview.text = "";
            currentTotal = 0.0;
            currentOperation = "";
        }

        powButton.setOnClickListener {
            currentTotal = textViewTotal.text.toString().toDouble();
            textViewTotal.text = Math.pow(currentTotal, 2.0).toString();
            textViewPreview.text = "";
            currentTotal = 0.0;
            currentOperation = "";
        }

        sqrtButton.setOnClickListener {
            currentTotal = textViewTotal.text.toString().toDouble();
            textViewTotal.text = Math.sqrt(currentTotal).toString();
            textViewPreview.text = "";
            currentTotal = 0.0;
            currentOperation = "";
        }

        equalsButton.setOnClickListener {
            if (currentOperation == "+"){
                // Second number
                secondNumber = textViewTotal.text.toString().toDouble();

                textViewTotal.text = (currentTotal + secondNumber).toString();
                textViewPreview.text = "";
                currentTotal = 0.0;
                currentOperation = "";
            }
            else if (currentOperation == "-"){
                // Second number
                secondNumber = textViewTotal.text.toString().toDouble();

                textViewTotal.text = (currentTotal - secondNumber).toString();
                textViewPreview.text = "";
                currentTotal = 0.0;
                currentOperation = "";
            } else if (currentOperation == "x"){
                // Second number
                secondNumber = textViewTotal.text.toString().toDouble();

                textViewTotal.text = (currentTotal * secondNumber).toString();
                textViewPreview.text = "";
                currentTotal = 0.0;
                currentOperation = "";
            } else if (currentOperation == "/"){
                // Second number
                secondNumber = textViewTotal.text.toString().toDouble();

                textViewTotal.text = (currentTotal / secondNumber).toString();
                textViewPreview.text = "";
                currentTotal = 0.0;
                currentOperation = "";
            }
        }
    }
}