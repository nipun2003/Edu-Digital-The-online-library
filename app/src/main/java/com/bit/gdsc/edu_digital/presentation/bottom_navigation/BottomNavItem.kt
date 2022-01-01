package com.bit.gdsc.edu_digital.presentation.bottom_navigation

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val name: String,
    @DrawableRes val iconId: Int,
    val route: String
)
