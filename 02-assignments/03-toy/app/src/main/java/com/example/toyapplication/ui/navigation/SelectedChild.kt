package com.example.toyapplication.ui.navigation

import com.example.toyapplication.data.Child

// Shared "box" to pass the chosen child from one screen to another
// - null  -> the form opens empty to register a new child
// - child -> the form opens filled to edit this child
object SelectedChild {
    var child: Child? = null
}
