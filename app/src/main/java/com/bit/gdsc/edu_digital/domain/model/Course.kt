package com.bit.gdsc.edu_digital.domain.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Course(
    val id: Int,
    val name: String,
    @DrawableRes val iconId: Int,
    @ColorRes val colorId: Int,
    @DrawableRes val backgroundImgId: Int
)