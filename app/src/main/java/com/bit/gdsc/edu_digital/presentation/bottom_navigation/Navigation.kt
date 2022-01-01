package com.bit.gdsc.edu_digital.presentation.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bit.gdsc.edu_digital.presentation.courses_screen.components.CoursesScreen
import com.bit.gdsc.edu_digital.presentation.downloads_screen.components.DownloadsScreen
import com.bit.gdsc.edu_digital.presentation.profile_screen.components.ProfileScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.CoursesScreen.route) {
        composable(route = Screen.CoursesScreen.route){
            CoursesScreen()
        }
        composable(route = Screen.DownloadsScreen.route){
            DownloadsScreen()
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen()
        }
    }
}