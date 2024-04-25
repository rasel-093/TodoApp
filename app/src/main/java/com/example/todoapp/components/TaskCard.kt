package com.example.todoapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todoapp.database.TaskItem
import com.example.todoapp.database.TaskViewModel

@Composable
fun TaskCard(taskItem: TaskItem, taskViewModel: TaskViewModel) {
    ElevatedCard(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        )
    ) {
        var refresh by rememberSaveable {
            mutableStateOf(true)
        }
        if(refresh == true || refresh == false){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Checkbox(
                    checked = taskItem.isCompleted == true.toString(),
                    onCheckedChange = {
                        taskItem.isCompleted = it.toString()
                        taskViewModel.updateTask(taskItem)
                        refresh = !refresh
                    } )
                Column(
                    modifier = Modifier.fillMaxWidth(0.75f)
                ) {
                    SemiBoldText(text = taskItem.title)
                    SimpleText(text = taskItem.details)
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    DateTimeText(text = taskItem.deadLineDate)
                    DateTimeText(text = taskItem.deadLineTime)
                }
            }
        }
    }
}