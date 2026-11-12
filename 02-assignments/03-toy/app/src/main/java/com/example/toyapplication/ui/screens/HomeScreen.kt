package com.example.toyapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyapplication.ui.navigation.Routes
import com.example.toyapplication.ui.navigation.SelectedChild
import com.example.toyapplication.viewmodel.ChildViewModel
import java.util.Locale

@Composable
fun HomeScreen(navController: NavController, viewModel: ChildViewModel) {
    var count by remember { mutableIntStateOf(0) }
    var averageAge by remember { mutableStateOf<Double?>(null) }

    // Runs every time this screen is shown (also when coming back from another screen)
    LaunchedEffect(Unit) {
        viewModel.countChildren { count = it }
        viewModel.averageAge { averageAge = it }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Children's Clinic", style = MaterialTheme.typography.headlineMedium)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Registered children: $count")

                val averageText = averageAge?.let { "%.1f years".format(Locale.US, it) } ?: "no data"
                Text(text = "Average age: $averageText")
            }
        }

        Button(
            onClick = {
                SelectedChild.child = null // empty form = register a new child
                navController.navigate(Routes.CHILD_FORM)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Register child")
        }

        Button(
            onClick = { navController.navigate(Routes.CHILD_LIST) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Children list")
        }

        Button(
            onClick = { navController.navigate(Routes.SEARCH) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Search by CPF")
        }
    }
}
