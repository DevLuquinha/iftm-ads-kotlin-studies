package com.example.toyapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toyapplication.data.Child

// Card that shows all the data of one child.
// onEdit and onDelete are optional: when null, the button is not shown
// (useful to reuse this card on the search screen).
@Composable
fun ChildCard(
    child: Child,
    onEdit: (() -> Unit)? = null,
    onDelete: (() -> Unit)? = null
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = child.childName, style = MaterialTheme.typography.titleMedium)
            Text(text = "CPF: ${child.childCpf}")
            Text(text = "Age: ${child.childAge}")
            Text(text = "Guardian: ${child.guardianName}")
            Text(text = "Guardian's CPF: ${child.guardianCpf}")
            Text(text = "Email: ${child.guardianEmail}")
            Text(text = "Phone: ${child.guardianPhone}")
            Text(text = "Professional: ${child.professionalName}")

            if (onEdit != null || onDelete != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    if (onEdit != null) {
                        TextButton(onClick = onEdit) {
                            Text(text = "Edit")
                        }
                    }
                    if (onDelete != null) {
                        TextButton(onClick = onDelete) {
                            Text(text = "Delete", color = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            }
        }
    }
}
