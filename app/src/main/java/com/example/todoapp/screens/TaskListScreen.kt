package com.example.todoapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.components.FilterButtonRow
import com.example.todoapp.components.SwipeToDeleteContainer
import com.example.todoapp.components.TaskCard
import com.example.todoapp.database.TaskViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun TaskListScreen(taskViewModel: TaskViewModel) {

    val taskList = taskViewModel.allTask.observeAsState(listOf()).value
    //Date for filtering task items

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val today = LocalDate.now()
    val formattedToday = today.format(formatter).toString()
    val formattedTomorrow = today.plusDays(1).format(formatter).toString()
    val currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
    Log.d("Today Date", formattedToday)
    Log.d("Tomorrow Date", formattedTomorrow)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        //HeaderCard()
        var filteredBy by rememberSaveable {
            mutableStateOf("All")
        }
        FilterButtonRow {
            filteredBy = it
            Log.d("FilteredText", it)
        }

        val filteredTaskList = taskList.filter {
            when (filteredBy) {
                "Today" -> it.deadLineDate == formattedToday && it.isCompleted == false.toString()
                "Tomorrow" -> it.deadLineDate == formattedTomorrow && it.isCompleted == false.toString()
                "Missed" -> {
                    (it.deadLineDate < formattedToday
                            || (it.deadLineDate == formattedToday
                            && it.deadLineTime < currentTime)) && it.isCompleted == false.toString()
                }

                "Done" -> it.isCompleted == true.toString()
                else -> {
                    true
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (taskList.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.comic),
                    contentDescription = "empty list",
                )
                Text(text = "There is no item in the list")
            }
        } else {
            LazyColumn {
                items(
                    items = filteredTaskList,
                    key = { it.id.toString() }
                ) { taskItem ->
                    SwipeToDeleteContainer(item = taskItem, onDelete = {
                        taskViewModel.deleteTask(taskItem)
                    }) {
                        TaskCard(taskItem = it, taskViewModel = taskViewModel)
                    }
                }
            }
        }
    }
}