package com.bit.gdsc.edu_digital.presentation.bottom_navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bit.gdsc.edu_digital.presentation.course_detail_screen.components.CourseDetailScreen
import com.bit.gdsc.edu_digital.presentation.courses_screen.components.CoursesScreen
import com.bit.gdsc.edu_digital.presentation.question_screen.components.QuestionScreen
import com.bit.gdsc.edu_digital.presentation.profile_screen.components.ProfileScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController,
showBar: (Boolean) -> Unit) {
    NavHost(navController = navController, startDestination = "Course", route = "root") {
        homeGraph(navController){
            showBar(it)
        }
        composable(
            route = Screen.CoursesScreen.route+"/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            showBar(false)
            CourseDetailScreen()
        }
    }
}

@ExperimentalMaterialApi
fun NavGraphBuilder.homeGraph(navController: NavHostController,
                              showBar : (Boolean) -> Unit
){
    navigation(startDestination = Screen.CoursesScreen.route, route = "Course"){
        composable(
            route = Screen.CoursesScreen.route
        ){
            showBar(true)
            CoursesScreen(navController)
        }
        composable(route = Screen.DownloadsScreen.route){
            showBar(true)
            QuestionScreen()
        }
        composable(route = Screen.ProfileScreen.route){
            showBar(true)
            ProfileScreen()
        }
    }
}