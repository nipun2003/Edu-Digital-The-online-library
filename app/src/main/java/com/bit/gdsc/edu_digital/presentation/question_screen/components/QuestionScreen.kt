package com.bit.gdsc.edu_digital.presentation.question_screen.components

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.data.remote.dto.QuestionDtoItem
import com.bit.gdsc.edu_digital.presentation.question_screen.QuestionViewModel
import com.bit.gdsc.edu_digital.presentation.ui.theme.*

@ExperimentalMaterialApi
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
                val clr : Color = when(it%4){
                    0 -> Color1
                    1 -> Color2
                    2 -> Color3
                    else -> Color4
                }
                QuestionCard(
                    modifier = Modifier.fillMaxWidth(),
                    questionItem = data[it],
                    clr
                )
            }
            item {
                Spacer(modifier = Modifier.size(SmallIconClip))
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    questionItem: QuestionDtoItem,
    clr: Color
) {
    val context = LocalContext.current
    Surface(
        color = clr,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        elevation = 5.dp,
        onClick = {
            val url : String = questionItem.questionLink
            val builder = CustomTabsIntent.Builder();
            val customTabsIntent = builder.build();
            customTabsIntent.launchUrl(context, Uri.parse(url));
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(2.5f)
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
                        style = Typography.h3,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Share the problem question link to the Computer to solve",
                        style = Typography.body1
                    )
                }
            }
        }
    }
}