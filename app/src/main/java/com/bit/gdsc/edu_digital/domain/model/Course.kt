package com.bit.gdsc.edu_digital.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.bit.gdsc.edu_digital.R

data class Course(
    val id: Int,
    val name: String,
    @DrawableRes val iconId: Int,
    val color: Color,
    @DrawableRes val backgroundImgId: Int
)

val courses: List<Course> = listOf(
    Course(
        id = 1,
        name = "CPP",
        iconId = R.drawable.ic_bottom_nav_courses,
        color = Color.Green,
        backgroundImgId = R.drawable.top_image_courses_screen
    ),
    Course(
        id = 2,
        name = "Java",
        iconId = R.drawable.ic_bottom_nav_courses,
        color = Color.Green,
        backgroundImgId = R.drawable.top_image_courses_screen
    ),
    Course(
        id = 3,
        name = "Data Structure & Algorithm",
        iconId = R.drawable.ic_bottom_nav_courses,
        color = Color.Green,
        backgroundImgId = R.drawable.top_image_courses_screen
    )
)