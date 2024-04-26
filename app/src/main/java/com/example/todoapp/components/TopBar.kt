package com.example.todoapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.blackFont
import com.example.todoapp.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Todo",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = blackFont
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = primaryColor
        )
    )
}