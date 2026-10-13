package com.example.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myFirstText()
        }
    }
}

@Composable
fun myFirstText(){
    Column(Modifier.padding(25.dp)) {
        Text("Hello World!")
        Text("Uai, what day is today?")
        Text("Class after holiday...")
        Row(){
            Text("On side")
            Text("On another side")
        }
    }
}