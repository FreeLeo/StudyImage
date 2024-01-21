package com.lingsi.studyimage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lingsi.studyimage.ui.components.HomeScreen
import com.lingsi.studyimage.ui.components.MainScreen

@Composable
fun StudyImageNavGraph() {
    val navController = rememberNavController()
    val navActions = remember(navController) {
        StudyImageNavigationActions(navController)
    }
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navigateToMain = navActions.navigateToMain) }
        composable("main") { MainScreen() }
    }
}