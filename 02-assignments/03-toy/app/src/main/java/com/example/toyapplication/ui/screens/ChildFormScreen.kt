package com.example.toyapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyapplication.data.Child
import com.example.toyapplication.viewmodel.ChildViewModel

@Composable
fun ChildFormScreen(navController: NavController, viewModel: ChildViewModel) {
    val context = LocalContext.current

    // One state for each field of the form
    var childCpf by remember { mutableStateOf("") }
    var childName by remember { mutableStateOf("") }
    var childAge by remember { mutableStateOf("") }
    var guardianCpf by remember { mutableStateOf("") }
    var guardianName by remember { mutableStateOf("") }
    var guardianEmail by remember { mutableStateOf("") }
    var guardianPhone by remember { mutableStateOf("") }
    var professionalName by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Register child", style = MaterialTheme.typography.headlineSmall)

        FormField("Child's CPF", childCpf, { childCpf = it }, KeyboardType.Number)
        FormField("Child's name", childName, { childName = it })
        FormField("Child's age", childAge, { childAge = it }, KeyboardType.Number)
        FormField("Guardian's CPF", guardianCpf, { guardianCpf = it }, KeyboardType.Number)
        FormField("Guardian's name", guardianName, { guardianName = it })
        FormField("Guardian's email", guardianEmail, { guardianEmail = it }, KeyboardType.Email)
        FormField("Guardian's phone", guardianPhone, { guardianPhone = it }, KeyboardType.Phone)
        FormField("Professional's name", professionalName, { professionalName = it })

        errorMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }

        Button(
            onClick = {
                val age = childAge.toIntOrNull()
                val requiredFields = listOf(
                    childCpf, childName, guardianCpf, guardianName,
                    guardianEmail, guardianPhone, professionalName
                )

                if (requiredFields.any { it.isBlank() } || age == null) {
                    errorMessage = "Fill in all fields (age must be a number)."
                } else {
                    val child = Child(
                        childCpf = childCpf.trim(),
                        guardianCpf = guardianCpf.trim(),
                        childName = childName.trim(),
                        guardianEmail = guardianEmail.trim(),
                        guardianPhone = guardianPhone.trim(),
                        childAge = age,
                        guardianName = guardianName.trim(),
                        professionalName = professionalName.trim()
                    )

                    viewModel.insert(child) { success ->
                        if (success) {
                            Toast.makeText(context, "Child registered!", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        } else {
                            errorMessage = "A child with this CPF is already registered."
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save")
        }

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Back")
        }
    }
}

// Reusable text field, so we don't repeat the same OutlinedTextField 8 times
@Composable
private fun FormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth()
    )
}
