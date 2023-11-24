package com.example.todoapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskCard() {
    ElevatedCard(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                SemiBoldText(text = "Title")
                SemiBoldText(text = "Details")
            }
            Column {
                SemiBoldText(text = "11/12/23")
                SemiBoldText(text = "05:20")
            }
        }
    }
}