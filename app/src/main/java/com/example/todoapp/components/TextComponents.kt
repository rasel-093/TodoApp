package com.example.todoapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.blackFont

@Composable
fun SemiBoldText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = blackFont,
        maxLines = 1,
        modifier = Modifier.padding(2.dp)
    )
}

@Composable
fun BoldText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = blackFont,
        maxLines = 1,
        modifier = Modifier.padding(2.dp)
    )
}

@Composable
fun SimpleText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = blackFont,
        maxLines = 1,
        modifier = Modifier.padding(2.dp)
    )
}

@Composable
fun DateTimeText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = blackFont,
        maxLines = 1,
        modifier = Modifier.padding(2.dp)
    )
}
