package com.bit.gdsc.edu_digital.presentation.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bit.gdsc.edu_digital.presentation.course_detail_screen.components.CourseDetailScreen
import com.bit.gdsc.edu_digital.presentation.courses_screen.components.CoursesScreen
import com.bit.gdsc.edu_digital.presentation.downloads_screen.components.DownloadsScreen
import com.bit.gdsc.edu_digital.presentation.profile_screen.components.ProfileScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Course", route = "root") {
        courseGraph(navController)
        composable(route = Screen.DownloadsScreen.route){
            DownloadsScreen()
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen()
        }
    }
}

fun NavGraphBuilder.courseGraph(navController: NavHostController){
    navigation(startDestination = Screen.CoursesScreen.route, route = "Course"){
        composable(
            route = Screen.CoursesScreen.route
        ){
            CoursesScreen(navController)
        }
        composable(
            route = Screen.CoursesScreen.route+"/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            CourseDetailScreen()
        }
    }
}