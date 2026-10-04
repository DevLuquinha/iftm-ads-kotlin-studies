package com.example.bhaskaracalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var title : TextView
    lateinit var coffiencientA : EditText
    lateinit var coffiencientB : EditText
    lateinit var coffiencientC : EditText
    lateinit var calculateButton : Button
    lateinit var roots : TextView;
    lateinit var xv : TextView;
    lateinit var yv : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.tv_title)
        coffiencientA = findViewById(R.id.et_coefficientA)
        coffiencientB = findViewById(R.id.et_coefficientB)
        coffiencientC = findViewById(R.id.et_coefficientC)
        calculateButton = findViewById(R.id.btn_calculate)
        roots = findViewById(R.id.tv_roots)
        xv = findViewById(R.id.tv_xv)
        yv = findViewById(R.id.tv_yv)

        calculateButton.setOnClickListener {
            val delta : Double
            val a : Double = coffiencientA.text.toString().toDouble()
            val b : Double = coffiencientB.text.toString().toDouble()
            val c : Double = coffiencientC.text.toString().toDouble()

            delta = Math.pow(b, 2.0) - (4 * a * c)

            var tempRoot1 : Double = 0.0
            var tempRoot2 : Double = 0.0

            var xVertex : Double = 0.0
            var yVertex : Double = 0.0

            var resultMessage : String = ""

            // 2 roots
            if (delta > 0){
                tempRoot1 = (-b + Math.sqrt(delta)) / 2 * a
                tempRoot2 = (-b - Math.sqrt(delta)) / 2 * a

                resultMessage = "Root 1: $tempRoot1 and Root 2:$tempRoot2"
            } else if (delta == 0.0){ // 1 root
                tempRoot1 = (-b + Math.sqrt(delta)) / 2 * a

                resultMessage = "Root 1: $tempRoot1 os equal Root 2:$tempRoot1"
            } else if (delta < 0) {
                resultMessage = "There is not real root :("
            }

            xVertex = -b / (2 * a)
            yVertex = -delta / (4 * a)

            roots.text = resultMessage
            xv.text = "The x of vertex is $xVertex"
            yv.text = "The y of vertex is $yVertex"
        }
    }
}