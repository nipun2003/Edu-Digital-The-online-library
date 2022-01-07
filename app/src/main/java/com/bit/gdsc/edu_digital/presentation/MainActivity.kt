package com.bit.gdsc.edu_digital.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bit.gdsc.edu_digital.presentation.bottom_navigation.BottomNavBar
import com.bit.gdsc.edu_digital.presentation.bottom_navigation.Navigation
import com.bit.gdsc.edu_digital.presentation.ui.theme.EduDigitalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EduDigitalTheme {
                BottomNavBar()
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EduDigitalTheme {
        BottomNavBar()
    }
}