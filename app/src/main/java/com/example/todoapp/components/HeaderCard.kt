package com.example.todoapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

//@Composable
//fun HeaderCard() {

//    var currentDate by remember {
//        mutableStateOf(LocalDate.now())
//    }
//    var currentTime by remember {
//        mutableStateOf(LocalTime.now())
//    }
//    LaunchedEffect(Unit) {
//        while (true) {
//            delay(1000)
//            currentDate = LocalDate.now()
//            currentTime = LocalTime.now()
//        }
//    }
//    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
//    var formattedCurrentDate = currentDate.format(dateFormatter)
//
//    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
//    var formattedTime = currentTime.format(timeFormatter)

//    ElevatedCard(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clip(RoundedCornerShape(8.dp)),
//        colors = CardDefaults.cardColors(
//            containerColor = Color(0xFFFFFFFF)
//        )
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            BoldText(text = "Your Tasks")
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier
//                    .fillMaxWidth(0.6f)
//            ) {
//                BoldText(text = formattedCurrentDate.toString())
//                BoldText(text = formattedTime.toString())
//            }
//        }
//        val filterItems = arrayListOf("Today", "Tomorrow", "Missed", "Done")
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .horizontalScroll(rememberScrollState())
//        ) {
//            filterItems.forEach{btnText->
//                TextButton(
//                    modifier = Modifier
//                        .padding(start = 8.dp)
//                        .clip(RoundedCornerShape(8.dp))
//                        .background(Color.LightGray),
//                    onClick = {
//
//                }) {
//                    Text(text = btnText)
//                }
//            }
//        }
//    }
//}