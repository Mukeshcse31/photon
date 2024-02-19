package com.tutorials.photon.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tutorials.photon.ui.theme.composableViews.DetailsScreen
import com.tutorials.photon.ui.theme.composableViews.MainSchoolData
import com.tutorials.photon.ui.theme.network.School

@Composable
fun App_Nav(data: List<School>) {

    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = "Main") {


        composable("Main") {
            MainSchoolData(schoolList = data, navController = navController)
        }
        composable(
            route = "Details",
            arguments = listOf(
                navArgument("res") {
                    defaultValue = School("name","Overview", "opport1", "oppor2")
                    type = NavType.ParcelableType(School::class.java)
                })
        ) {                navBackStackEntry ->
            val res = navController.previousBackStackEntry?.savedStateHandle?.get("res") as School?
//            val res = navBackStackEntry.arguments?.getParcelable("res", School::class.java)
            DetailsScreen(schoolNames = res)
        }

    }


}
