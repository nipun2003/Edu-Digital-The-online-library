package com.bit.gdsc.edu_digital.presentation.question_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.data.remote.dto.QuestionDtoItem
import com.bit.gdsc.edu_digital.domain.model.DownloadedPdf
import com.bit.gdsc.edu_digital.presentation.question_screen.QuestionViewModel
import com.bit.gdsc.edu_digital.presentation.ui.theme.*

@Composable
fun QuestionScreen(
    viewModel: QuestionViewModel = hiltViewModel()
) {
    val questionState = viewModel.questionState.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(BigPadding)
    ) {
        if (questionState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (questionState.message != null) {
            questionState.message?.let { message ->
                Text(
                    text = message,
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.align(Alignment.Center)
                )

            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ){
            val data = questionState.data
            items(data.size){
                if(it>0){
                    Spacer(modifier = Modifier.size(SmallPadding))
                }
                QuestionCard(
                    modifier = Modifier.fillMaxWidth(),
                    questionItem = data[it]
                )
            }
            item {
                Spacer(modifier = Modifier.size(SmallIconClip))
            }
        }
    }
}

@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    questionItem: QuestionDtoItem
) {
    Surface(
        color = Color.White,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = SmallPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bottom_nav_downloads),
                    contentDescription = questionItem.topic,
                    modifier = Modifier
                        .size(SmallIconClip)
                        .padding(ExtraSmallPadding)
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = questionItem.topic,
                        style = Typography.h3
                    )
                    Text(
                        text = questionItem.questionLink,
                        style = Typography.body1
                    )
                }
            }
        }
    }
}