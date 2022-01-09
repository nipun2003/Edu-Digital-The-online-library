package com.bit.gdsc.edu_digital.presentation.course_detail_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.presentation.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun CourseDetailScreen(
    viewModel: CourseDetailViewModel = hiltViewModel()
) {
    val topicWiseState = viewModel.dsaTopicWiseState.value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = viewModel.title.value
            )
        }
    ) {
        if (topicWiseState.isLoading) {
            CircularProgressIndicator()
        }
        if (topicWiseState.message != null) {
            topicWiseState.message?.let { message ->
                Text(
                    text = message,
                    style = MaterialTheme.typography.h3
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(BigPadding)
        ) {
            LazyColumn {
                items(topicWiseState.data.size) {
                    if (it > 0) {
                        Spacer(modifier = Modifier.size(SmallPadding))
                    }
                    val clr : Color = when(it%4){
                        0 -> Color1
                        1 -> Color2
                        2 -> Color3
                        else -> Color4
                    }
                    ExpandableCard(topicItem = topicWiseState.data[it], bgColor = clr)
                }
            }
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background,
        elevation = ExtraSmallPadding
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = BigPadding, vertical = SmallPadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h2
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(ExtraBigPadding)
            )
        }
    }
}




