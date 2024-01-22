package com.lingsi.studyimage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lingsi.studyimage.data.CategoryType
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
        composable("main/{${StudyImageParams.PARAM_CATEGORY_TYPE}}", arguments = listOf(
            navArgument(StudyImageParams.PARAM_CATEGORY_TYPE){type = NavType.IntType}
        )) {
            val argument = requireNotNull(it.arguments)
            val categoryType = argument.getInt(StudyImageParams.PARAM_CATEGORY_TYPE)
            MainScreen(categoryType)
        }
    }
}