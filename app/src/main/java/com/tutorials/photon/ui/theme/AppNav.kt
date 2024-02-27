package com.tutorials.photon.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tutorials.photon.ui.theme.composableViews.DetailsScreen
import com.tutorials.photon.ui.theme.composableViews.MainSchoolData
import com.tutorials.photon.ui.theme.network.School

@Composable
fun App_Nav(data: List<School>) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Main"
    ) {
        composable(route = "Main") {
            MainSchoolData(schoolList = data, navController = navController)
        }
        composable(route = "Details") {
            val res = navController.previousBackStackEntry?.savedStateHandle?.get("res") as School?
            DetailsScreen(schoolNames = res)
        }
    }
}
