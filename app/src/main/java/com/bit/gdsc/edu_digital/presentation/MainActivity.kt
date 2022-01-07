package com.bit.gdsc.edu_digital.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bit.gdsc.edu_digital.data.remote.FirebaseManager
import com.bit.gdsc.edu_digital.presentation.bottom_navigation.BottomNavBar
import com.bit.gdsc.edu_digital.presentation.ui.theme.EduDigitalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseManager()
        setContent {
            EduDigitalTheme {
                BottomNavBar()
            }
        }
    }
}