package com.example.matrixexercises

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var numberInput : TextView;
    lateinit var btnVerify : Button;
    lateinit var matrixText : TextView;
    lateinit var resultText : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        exercise1();
//        exercise2();
        exercise3();
    }

    fun exercise1(){
        var columnSize = 5;
        var rowSize = 5;

        var matrix = createMatrix(columnSize, rowSize);
        populateMatrix(matrix, columnSize, rowSize);
        showMatrix(matrix, columnSize, rowSize);

        var rowThreeSum = 0;
        var columnTwoSum = 0;
        var mainDiagonalSum = 0;
        var secondDiagonalSum = 0;
        var allElementsSum = 0;

        var lastIndex = rowSize - 1;

        for (i in 0 until columnSize){
            for (j in 0 until rowSize){
                val matrixValue = matrix[i][j];

                if (i == 2){
                    rowThreeSum += matrixValue;
                }

                if (j == 1){
                    columnTwoSum += matrixValue;
                }

                if (i == j){
                    mainDiagonalSum += matrixValue;
                }

                if (j == lastIndex){
                    secondDiagonalSum += matrixValue;
                    lastIndex--;
                }

                allElementsSum += matrixValue;
            }
        }

        Log.i("DEBUG-TEST", "1.a) The sum of row 3 is $rowThreeSum");
        Log.i("DEBUG-TEST", "1.b) The sum of column 2 is $columnTwoSum");
        Log.i("DEBUG-TEST", "1.c) The sum of main diagonal is $mainDiagonalSum");
        Log.i("DEBUG-TEST", "1.d) The sum of second diagonal is $secondDiagonalSum");
        Log.i("DEBUG-TEST", "1.e) The sum of all elements is $allElementsSum");

        Log.i("DEBUG-TEST", "-------------------------------------------");
    }

    fun exercise2(){
        val columnSize = 4;
        val rowSize = 6;

        var matrixA = createMatrix(columnSize, rowSize);
        populateMatrix(matrixA, columnSize, rowSize);

        var matrixB = createMatrix(columnSize, rowSize);
        populateMatrix(matrixB, columnSize, rowSize);

        showMatrix(matrixA, columnSize, rowSize,  "Matrix A");
        showMatrix(matrixB, columnSize, rowSize,  "Matrix B");

        var matrixS = createMatrix(columnSize, rowSize);
        var matrixD = createMatrix(columnSize, rowSize);

        for (i in 0 until columnSize){
            for (j in 0 until rowSize){
                matrixS[i][j] = matrixA[i][j] + matrixB[i][j];
                matrixD[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }

        showMatrix(matrixS, columnSize, rowSize,  "Matrix S");
        showMatrix(matrixD, columnSize, rowSize,  "Matrix S");
    }

    fun exercise3(){
        numberInput = findViewById(R.id.et_number);
        btnVerify = findViewById(R.id.btn_verify);
        matrixText = findViewById(R.id.tv_matrix);
        resultText = findViewById(R.id.tv_result);

        var columnSize = 5;
        var rowSize = 5;

        var matrix = createMatrix(columnSize, rowSize);
        populateMatrix(matrix, columnSize, rowSize);

        var matrixMessage = "";
        for (i in 0 until columnSize){
            for (j in 0 until rowSize){
                matrixMessage += if (matrix[i][j] < 10) "[0${matrix[i][j]}] " else "[${matrix[i][j]}] ";
            }

            matrixMessage += "\n";
        }

        matrixText.text = matrixMessage;

        btnVerify.setOnClickListener {
            val rawNumber = numberInput.text.toString();
            if (rawNumber.isNullOrEmpty()){
                resultText.text = "Error! Type a number to check :(";
            } else {
                val targetNumber = rawNumber.toIntOrNull() ?: 0;

                val matrixContainsNumber = containsInMatrix(matrix, targetNumber)
                if (matrixContainsNumber){
                    resultText.text = "The $targetNumber already exists in the Matrix";
                } else {
                    resultText.text = "The $targetNumber doesn't exist in the Matrix";
                }
            }
        }
    }

    fun createMatrix(columnLength : Int, rowsLength: Int) : Array<IntArray> {
        var matrix = Array(columnLength, { IntArray(rowsLength) });

        return matrix;
    }

    fun populateMatrix(matrix : Array<IntArray>, columnLength : Int, rowsLength: Int) : Array<IntArray> {
        var matrixValue = 1;

        for (i in 0 until matrix.size){
            for (j in 0 until rowsLength){
                matrix[i][j] = matrixValue;
                matrixValue++;
            }
        }

        return matrix;
    }

    fun showMatrix(matrix : Array<IntArray>, columnSize : Int, rowSize : Int, prompt : String = "Default Matrix"){
        Log.i("DEBUG-TEST", prompt);
        Log.i("DEBUG-TEST", "-------------------------------------------");
        var matrixMessage = "";
        for (i in 0 until columnSize){
            for (j in 0 until rowSize){
                matrixMessage += if (matrix[i][j] < 10) "[0${matrix[i][j]}] " else "[${matrix[i][j]}] ";
            }

            matrixMessage += "\n";
        }
        Log.i("DEBUG-TEST", matrixMessage);
        Log.i("DEBUG-TEST", "-------------------------------------------");
    }

    fun containsInMatrix(matrix : Array<IntArray>, targetValue : Int) : Boolean{
        for (row in matrix){
            for (number in row){
                if (number == targetValue){
                    return true;
                }
            }
        }

        return false; // 404 not found
    }
}