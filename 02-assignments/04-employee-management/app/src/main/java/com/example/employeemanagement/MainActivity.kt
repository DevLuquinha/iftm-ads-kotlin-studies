package com.example.employeemanagement

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.employeemanagement.data.Employee
import com.example.employeemanagement.ui.theme.EmployeeManagementTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore
        setContent {
            LaunchedEffect(Unit) {
                val employeeTest = Employee(
                    "12345678987",
                    "Lucas Emmanuel",
                    20,
                    19.99
                )

                db.collection("employees")
                    .document(employeeTest.cpf)
                    .set(employeeTest)
                    .addOnSuccessListener {
                        Log.i("TEST-DEV", "A new employee was added successfully!")
                    }
                    .addOnFailureListener {
                        error -> Log.i("TEST-DEV", "Something was wrong! Error: $error")
                    }
            }

            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello World!")
    }
}