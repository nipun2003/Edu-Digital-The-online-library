package com.bit.gdsc.edu_digital.presentation.bottom_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.presentation.ui.theme.BottomSelectedColor
import com.bit.gdsc.edu_digital.presentation.ui.theme.BottomUnselectedColor

@ExperimentalMaterialApi
@Composable
fun BottomNavBar() {
    val navController = rememberNavController()
    val navItems = listOf(
        BottomNavItem(
            name = "Courses",
            route = Screen.CoursesScreen.route,
            iconId = R.drawable.ic_bottom_nav_courses
        ),
        BottomNavItem(
            name = "Questions",
            route = Screen.DownloadsScreen.route,
            iconId = R.drawable.ic_bottom_nav_downloads
        ),
        BottomNavItem(
            name = "Profile",
            route = Screen.ProfileScreen.route,
            iconId = R.drawable.ic_bottom_nav_profile
        )
    )
    var showBar by remember {
        mutableStateOf(
            true
        )
    }
    Scaffold(
        bottomBar = {
            if(showBar) {
                BottomNavBarState(
                    items = navItems,
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route) {
                            popUpTo(Screen.CoursesScreen.route)
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) {
        Navigation(navController = navController){
            showBar = it
        }
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
                selectedContentColor = BottomSelectedColor,
                unselectedContentColor = BottomUnselectedColor,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = item.iconId),
                            contentDescription = item.name,
                            modifier = Modifier.size(24.dp)
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