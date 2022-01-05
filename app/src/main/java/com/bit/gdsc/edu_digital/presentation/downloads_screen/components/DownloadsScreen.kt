package com.bit.gdsc.edu_digital.presentation.downloads_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bit.gdsc.edu_digital.domain.model.DownloadedPdf
import com.bit.gdsc.edu_digital.presentation.ui.theme.*
import com.bit.gdsc.edu_digital.R

@Composable
fun DownloadsScreen() {

    val downloadedPdfs = listOf<DownloadedPdf>(
        DownloadedPdf(
            "Merge Sort",
            "we will be learning about the merge sort in this pdf"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(BigPadding),
    ) {
        items(downloadedPdfs.size) {
            if (it > 0) {
                Spacer(modifier = Modifier.size(BigPadding))
            }
            DownloadCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3.9f)
                    .padding(horizontal = ExtraSmallPadding),
                downloadedPdf = downloadedPdfs[it]
            )
        }
        item {
            Spacer(modifier = Modifier.size(SmallIconClip))
        }
    }
}

@Composable
fun DownloadCard(
    modifier: Modifier = Modifier,
    downloadedPdf: DownloadedPdf
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
                    contentDescription = downloadedPdf.name,
                    modifier = Modifier
                        .size(SmallIconClip)
                        .padding(ExtraSmallPadding)
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = downloadedPdf.name,
                        style = Typography.h3
                    )
                    Text(
                        text = downloadedPdf.description,
                        style = Typography.body1
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EduDigitalTheme {
        DownloadsScreen()
    }
}