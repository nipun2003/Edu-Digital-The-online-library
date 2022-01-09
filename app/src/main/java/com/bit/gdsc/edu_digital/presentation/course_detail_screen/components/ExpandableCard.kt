package com.bit.gdsc.edu_digital.presentation.course_detail_screen.components

import android.net.Uri
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bit.gdsc.edu_digital.R
import com.bit.gdsc.edu_digital.data.remote.dto.DSATopicWiseDtoItem
import com.bit.gdsc.edu_digital.data.remote.dto.TopicLink
import com.bit.gdsc.edu_digital.presentation.ui.theme.BigPadding
import com.bit.gdsc.edu_digital.presentation.ui.theme.ExtraBigPadding
import com.bit.gdsc.edu_digital.presentation.ui.theme.ExtraSmallPadding
import com.bit.gdsc.edu_digital.presentation.ui.theme.SmallPadding

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    topicItem: DSATopicWiseDtoItem,
    bgColor: Color
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f
    )
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = MaterialTheme.shapes.large,
        color = bgColor,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = topicItem.topicName,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.weight(6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down arrow"
                    )
                }
            }

            if(expandedState){
                TopicLinkItems(topicItem.topicLinks)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TopicLinkItems(topicLinkItems: List<TopicLink>) {
    LazyRow {
        items(topicLinkItems.size){
            if(it>0){
                Spacer(modifier = Modifier.size(SmallPadding))
            }
            TopicLinkItemCard(item = topicLinkItems[it])
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TopicLinkItemCard(item : TopicLink) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .size(90.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 5.dp,
        color = Color.White,
        onClick = {
            val url : String = item.link
            val builder = CustomTabsIntent.Builder();
            val customTabsIntent = builder.build();
            customTabsIntent.launchUrl(context, Uri.parse(url));
        }
    ){
        when(item.linkType){
            "pdf" -> Image(
                painter = painterResource(id = R.drawable.icon_pdf),
                contentDescription ="pdf",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(BigPadding),
            )

            "youtube" -> Image(
                painter = painterResource(id = R.drawable.youtube),
                contentDescription ="youtube video",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(BigPadding),
            )

            "leetcode" -> Image(
                painter = painterResource(id = R.drawable.leetcode),
                contentDescription ="youtube video",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(BigPadding),
            )

            else -> Image(
                painter = painterResource(id = R.drawable.icon_gfg),
                contentDescription ="web view",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(BigPadding),
            )
        }
    }
}
