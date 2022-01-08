package com.bit.gdsc.edu_digital.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.presentation.ui.theme.Color1
import com.bit.gdsc.edu_digital.presentation.ui.theme.Color2
import com.bit.gdsc.edu_digital.presentation.ui.theme.Color3
import com.bit.gdsc.edu_digital.presentation.ui.theme.Color4

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
        name = "Data Structure",
        iconId = R.drawable.dsa,
        color = Color1,
        backgroundImgId = R.drawable.aa
    ),
    Course(
        id = 2,
        name = "Algorithm",
        iconId = R.drawable.algorithms,
        color = Color2,
        backgroundImgId = R.drawable.aa
    ),
    Course(
        id = 3,
        name = "CPP",
        iconId = R.drawable.c__,
        color = Color3,
        backgroundImgId = R.drawable.aa
    ),
    Course(
        id = 4,
        name = "Java",
        iconId = R.drawable.java,
        color = Color4,
        backgroundImgId = R.drawable.aa
    )
)