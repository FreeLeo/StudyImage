package com.lingsi.studyimage.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

object StudyImageDestinations {
    const val ROUTE_HOME = "home"
    const val ROUTE_MAIN = "main"
}

class StudyImageNavigationActions(navController: NavController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(StudyImageDestinations.ROUTE_HOME) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToMain: () -> Unit = {
        navController.navigate(StudyImageDestinations.ROUTE_MAIN)
    }
}