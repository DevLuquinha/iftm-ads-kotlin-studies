package com.example.toyapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.toyapplication.ui.screens.ChildFormScreen
import com.example.toyapplication.ui.screens.ChildListScreen
import com.example.toyapplication.ui.screens.HomeScreen
import com.example.toyapplication.viewmodel.ChildViewModel

// Names of the routes (screens) of the app
object Routes {
    const val HOME = "home"
    const val CHILD_FORM = "child_form"
    const val CHILD_LIST = "child_list"
}

@Composable
fun AppNavigation(viewModel: ChildViewModel, modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        modifier = modifier
    ) {
        composable(Routes.HOME) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(Routes.CHILD_FORM) {
            ChildFormScreen(navController = navController, viewModel = viewModel)
        }
        composable(Routes.CHILD_LIST) {
            ChildListScreen(navController = navController, viewModel = viewModel)
        }
    }
}
