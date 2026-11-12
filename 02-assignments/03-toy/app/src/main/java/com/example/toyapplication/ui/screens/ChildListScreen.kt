package com.example.toyapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyapplication.data.Child
import com.example.toyapplication.ui.components.ChildCard
import com.example.toyapplication.ui.navigation.Routes
import com.example.toyapplication.ui.navigation.SelectedChild
import com.example.toyapplication.viewmodel.ChildViewModel

@Composable
fun ChildListScreen(navController: NavController, viewModel: ChildViewModel) {
    val context = LocalContext.current

    var children by remember { mutableStateOf<List<Child>>(emptyList()) }

    // Child waiting for delete confirmation (null = dialog closed)
    var childToDelete by remember { mutableStateOf<Child?>(null) }

    // Loads the list every time this screen is shown (also when coming back from the edit form)
    LaunchedEffect(Unit) {
        viewModel.findAll { children = it }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Children list", style = MaterialTheme.typography.headlineSmall)

        if (children.isEmpty()) {
            Text(text = "No children registered yet.")
        }

        // LazyColumn only draws the items visible on the screen (like RecyclerView)
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(children) { child ->
                ChildCard(
                    child = child,
                    onEdit = {
                        SelectedChild.child = child
                        navController.navigate(Routes.CHILD_FORM)
                    },
                    onDelete = { childToDelete = child }
                )
            }
        }

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Back")
        }
    }

    // Confirmation dialog before deleting
    childToDelete?.let { child ->
        AlertDialog(
            onDismissRequest = { childToDelete = null },
            title = { Text(text = "Delete child") },
            text = { Text(text = "Do you really want to delete ${child.childName}?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.delete(child) {
                            Toast.makeText(context, "Child deleted!", Toast.LENGTH_SHORT).show()
                            childToDelete = null
                            viewModel.findAll { children = it }
                        }
                    }
                ) {
                    Text(text = "Delete", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { childToDelete = null }) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}
