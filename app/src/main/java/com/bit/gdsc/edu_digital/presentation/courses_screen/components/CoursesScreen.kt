package com.bit.gdsc.edu_digital.presentation.courses_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.domain.model.Course
import com.bit.gdsc.edu_digital.domain.model.courses
import com.bit.gdsc.edu_digital.presentation.bottom_navigation.Screen
import com.bit.gdsc.edu_digital.presentation.ui.theme.*

@Composable
fun CoursesScreen(
    navController: NavController
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(BigPadding),
        ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.top_image_courses_screen),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Inside,
                alignment = Alignment.Center
            )
        }
        items(courses.size) {
            if (it > 0) {
                Spacer(modifier = Modifier.size(BigPadding))
            }
            CoursesCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2.6f)
                    .padding(horizontal = ExtraSmallPadding),
                course = courses[it]

            ){ id->
                navController.navigate(Screen.CoursesScreen.route+"/$id")
            }
        }
        item {
            Spacer(modifier = Modifier.size(SmallIconClip))
        }
    }
}

@Composable
fun CoursesCard(
    modifier: Modifier = Modifier,
    course: Course,
    onClick : (Int) -> Unit
) {
    Surface(
        color = course.color,
        shape = MaterialTheme.shapes.large,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick(course.id) }
        ) {
            Image(
                painter =
                painterResource(id = course.backgroundImgId),
                contentDescription = "Background image",
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(-1f),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center
            )
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = SmallPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = course.iconId),
                    contentDescription = course.name,
                    modifier = Modifier
                        .size(SmallIconClip)
                        .padding(ExtraSmallPadding)
                )
                Text(
                    text = course.name,
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}