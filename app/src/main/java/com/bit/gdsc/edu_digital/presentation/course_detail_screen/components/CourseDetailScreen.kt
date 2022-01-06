package com.bit.gdsc.edu_digital.presentation.course_detail_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.bit.gdsc.edu_digital.presentation.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun CourseDetailScreen(
    viewModel: CourseDetailViewModel = hiltViewModel()
) {
    val topicWiseState = viewModel.dsaTopicWiseState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(BigPadding)
    ) {
        if (topicWiseState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (topicWiseState.message != null) {
            topicWiseState.message?.let { message ->
                Text(
                    text = message,
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        LazyColumn{
            items(topicWiseState.data.size){
                if(it>0){
                    Spacer(modifier = Modifier.size(SmallPadding))
                }

                val clrCheck = it%4;
                when(it){
                    0 -> ExpandableCard(topicWiseState.data[it], Color1)
                    1 -> ExpandableCard(topicWiseState.data[it], Color2)
                    2 -> ExpandableCard(topicWiseState.data[it], Color3)
                    else -> ExpandableCard(topicWiseState.data[it], Color4)
                }

            }
        }
    }
}



