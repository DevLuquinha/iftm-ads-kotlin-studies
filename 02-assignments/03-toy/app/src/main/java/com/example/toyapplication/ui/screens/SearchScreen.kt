package com.example.toyapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyapplication.data.Child
import com.example.toyapplication.ui.components.ChildCard
import com.example.toyapplication.viewmodel.ChildViewModel

@Composable
fun SearchScreen(navController: NavController, viewModel: ChildViewModel) {
    // false = search by the child's CPF / true = search by the guardian's CPF
    var searchByGuardian by remember { mutableStateOf(false) }
    var cpf by remember { mutableStateOf("") }

    var results by remember { mutableStateOf<List<Child>>(emptyList()) }
    var hasSearched by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Clears the old results when the user changes the type of search
    fun changeSearchType(byGuardian: Boolean) {
        searchByGuardian = byGuardian
        results = emptyList()
        hasSearched = false
        errorMessage = null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Search", style = MaterialTheme.typography.headlineSmall)

        // Type of search
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = !searchByGuardian,
                onClick = { changeSearchType(byGuardian = false) }
            )
            Text(text = "Child's CPF")

            RadioButton(
                selected = searchByGuardian,
                onClick = { changeSearchType(byGuardian = true) }
            )
            Text(text = "Guardian's CPF")
        }

        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text(text = if (searchByGuardian) "Guardian's CPF" else "Child's CPF") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        errorMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }

        Button(
            onClick = {
                if (cpf.isBlank()) {
                    errorMessage = "Type a CPF to search."
                } else {
                    errorMessage = null

                    if (searchByGuardian) {
                        // One guardian can have many children -> list
                        viewModel.findByGuardianCpf(cpf.trim()) { children ->
                            results = children
                            hasSearched = true
                        }
                    } else {
                        // The child's CPF is unique -> one child or null
                        viewModel.findByChildCpf(cpf.trim()) { child ->
                            results = listOfNotNull(child)
                            hasSearched = true
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Search")
        }

        if (hasSearched && results.isEmpty()) {
            Text(text = "No child found.")
        }

        if (results.size > 1) {
            Text(text = "${results.size} children found:")
        }

        // Results (cards without the Edit/Delete buttons)
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(results) { child ->
                ChildCard(child = child)
            }
        }

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Back")
        }
    }
}
