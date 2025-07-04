package com.example.todoapp.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.todoapp.getDateInFormat

//@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
//@Composable
//fun BottomSheetScreen(taskViewModel: TaskViewModel, sheetVisibility: (Boolean)->Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top
//    ) {
//        var title by rememberSaveable {
//            mutableStateOf("")
//        }
//        var details by rememberSaveable {
//            mutableStateOf("")
//        }
//        var deadlineTime by rememberSaveable {
//            mutableStateOf("")
//        }
//        var deadLineDate by rememberSaveable {
//            mutableStateOf("")
//        }
//        Box(modifier = Modifier.fillMaxWidth()){
//            Column(modifier = Modifier.fillMaxWidth()) {
//                BoldText(text = "New Task")
//                CustomTextField(text = title, onValueChange = {title = it},"Title",
//                    KeyboardOptions(imeAction = ImeAction.Next)
//                )
//                CustomTextField(text = details, onValueChange = {details = it},"Details",
//                    KeyboardOptions(imeAction = ImeAction.Next)
//                )
//                CalendarField(deadLineDate, { deadLineDate = it })
//                TimeField(deadlineTime,{deadlineTime = it})
//            }
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Row (
//            horizontalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier.fillMaxWidth(0.7f)
//        ){
//            Button(
//                onClick = {
//                          sheetVisibility(false)
//                },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = primaryColor
//                )
//            ) {
//                Text(
//                    text = "Cancel",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 16.sp,
//                    color = blackFont
//                )
//            }
//            Button(
//                onClick = {
//                          val taskItem = TaskItem(
//                              null,
//                              title,
//                              details,
//                              (false).toString(),
//                              deadLineDate,
//                              deadlineTime
//
//                          )
//                    Log.d("Deadline date",deadLineDate)
//                    Log.d("Deadline time",deadlineTime)
//                    taskViewModel.inserTask(taskItem)
//                    sheetVisibility(false)
//                },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = primaryColor
//                )
//            ) {
//                Text(
//                    text = "Save",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 16.sp,
//                    color = blackFont
//                )
//            }
//        }
//        Spacer(modifier = Modifier.padding(20.dp))
//    }
//}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomDatePicker(selectedDate: (String) -> Unit, openDialog: (Boolean) -> Unit) {
//
//    //val selectedDate = rememberSaveable{ mutableStateOf(LocalDate.now()) }
//    val context = LocalContext.current
//
//    val datePickerState = rememberDatePickerState(
//        yearRange = IntRange(2023, 2030),
//        initialDisplayMode = DisplayMode.Picker
//    )
//
//    DatePickerDialog(
//        onDismissRequest = { },
//        confirmButton = {
//            Button(onClick = {
//                if (datePickerState.selectedDateMillis != null) {
//                    val dateMillis = datePickerState.selectedDateMillis
//                    val formattedDate = getDateInFormat(dateMillis!!)
//                    selectedDate(formattedDate)
//                    openDialog(false)
//                } else {
//                    Toast.makeText(context, "Please select date", Toast.LENGTH_SHORT).show()
//                }
//            }) {
//                Text(text = "Confirm")
//            }
//        },
//        dismissButton = {
//            Button(onClick = { openDialog(false) }) {
//                Text(text = "Cancel")
//            }
//        }
//    ) {
//        DatePicker(
//            state = datePickerState,
//            modifier = Modifier.padding(8.dp)
//        )
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomTimePickerDialog(selectedTime: (String) -> Unit, showDialog: (Boolean) -> Unit) {
//    AlertDialog(
//        onDismissRequest = {  },
//
//        ) {
//        val timePickerState =
//            rememberTimePickerState(initialHour = 0, initialMinute = 30, is24Hour = false)
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp)
//                .background(Color(0xFFFFFFFF))
//                .clip(RoundedCornerShape(8.dp))
//        ) {
//            TimePicker(
//                state = timePickerState,
//                colors = TimePickerDefaults.colors(
//                    containerColor = Color(0xFFFFFFFF)
//                ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp)
//            )
//            Row(
//                horizontalArrangement = Arrangement.End,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                TextButton(onClick = { showDialog(false) }) {
//                    Text(text = "Cancel")
//                }
//                TextButton(onClick = {
//                    selectedTime("${timePickerState.hour.toString()}:${timePickerState.minute.toString()}")
//                    showDialog(false)
//                }) {
//                    Text(text = "Confirm")
//                }
//            }
//        }
//    }
//}

