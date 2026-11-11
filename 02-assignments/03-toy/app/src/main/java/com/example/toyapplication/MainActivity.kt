package com.example.toyapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.toyapplication.data.AppDatabase
import com.example.toyapplication.data.DatabaseProperties
import com.example.toyapplication.repository.ChildRepository
import com.example.toyapplication.ui.navigation.AppNavigation
import com.example.toyapplication.ui.theme.ToyApplicationTheme
import com.example.toyapplication.viewmodel.ChildViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ChildViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DatabaseProperties.DB_NAME
        ).build()

        val dao = db.childDao()
        val repository = ChildRepository(dao)
        viewModel = ChildViewModel(repository)

        setContent {
            ToyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
