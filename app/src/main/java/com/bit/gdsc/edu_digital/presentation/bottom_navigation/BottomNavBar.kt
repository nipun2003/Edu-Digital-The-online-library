package com.bit.gdsc.edu_digital.presentation.bottom_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavBar() {
    val navController = rememberNavController()
    val navItems = listOf(
        BottomNavItem(
            name = "Courses",
            route = Screen.CoursesScreen.route,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Downloads",
            route = Screen.DownloadsScreen.route,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Profile",
            route = Screen.ProfileScreen.route,
            icon = Icons.Default.Home
        )
    )
    Scaffold(
        bottomBar = {
            BottomNavBarState(
                items = navItems,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Navigation(navController = navController)
    }
}

@Composable
fun BottomNavBarState(
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                        if(selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}