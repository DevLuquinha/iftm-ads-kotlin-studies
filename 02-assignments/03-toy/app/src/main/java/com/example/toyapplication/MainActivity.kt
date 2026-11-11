package com.example.toyapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.room.Room
import com.example.toyapplication.data.AppDatabase
import com.example.toyapplication.data.DatabaseProperties
import com.example.toyapplication.repository.ChildRepository
import com.example.toyapplication.viewmodel.ChildViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ChildViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DatabaseProperties.DB_NAME
        ).build()

        val dao = db.childDao()
        val repository = ChildRepository(dao)
        viewModel = ChildViewModel(repository)

        setContent {
            HelloWorldMethod("World")
        }
    }
}

@Composable
fun HelloWorldMethod(name: String) {
    Text(
        text = "Hello $name!"
    )
}