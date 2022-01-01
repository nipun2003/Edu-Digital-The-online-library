package com.bit.gdsc.edu_digital.presentation.bottom_navigation

sealed class Screen(val route: String) {
    object CoursesScreen : Screen("courses_screen")
    object DownloadsScreen : Screen("downloads_screen")
    object ProfileScreen : Screen("profile_screen")
}