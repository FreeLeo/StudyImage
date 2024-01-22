package com.lingsi.studyimage.ui

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.lingsi.studyimage.data.CategoryType

object StudyImageParams{
    const val PARAM_CATEGORY_TYPE = "categoryType"
}

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
    val navigateToMain: (categoryType: Int) -> Unit = {
        navController.navigate(route = "${StudyImageDestinations.ROUTE_MAIN}/$it")
    }
}