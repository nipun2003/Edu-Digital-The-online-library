package com.bit.gdsc.edu_digital.presentation.courses_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.domain.model.Course
import com.bit.gdsc.edu_digital.presentation.bottom_navigation.BottomNavBar
import com.bit.gdsc.edu_digital.presentation.ui.theme.EduDigitalTheme

@Composable
fun CoursesScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ){
        item {
            Image(
                painter = painterResource(id = R.drawable.top_image_courses_screen),
                contentDescription = "",
                modifier = Modifier.size(400.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EduDigitalTheme {
        CoursesScreen()
    }
}