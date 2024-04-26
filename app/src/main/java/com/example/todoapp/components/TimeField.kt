package com.example.todoapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeField(deadLineTime: String, onValueChange: (String) -> Unit) {
    var selectedTime by rememberSaveable {
        mutableStateOf("")
    }
    var openDialog by rememberSaveable {
        mutableStateOf(false)
    }
    if (openDialog) {
        //CustomTimePickerDialog({selectedTime = it},{ openDialog = it })
        AlertDialog(
            onDismissRequest = { /*TODO*/ },

            ) {
            val timePickerState =
                rememberTimePickerState(initialHour = 0, initialMinute = 30, is24Hour = true)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color(0xFFFFFFFF))
                    .clip(RoundedCornerShape(8.dp))
            ) {
                TimePicker(
                    state = timePickerState,
                    colors = TimePickerDefaults.colors(
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = { openDialog = false }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = {
                        //selectedTime("${timePickerState.hour.toString()}:${timePickerState.minute.toString()}")
                        // showDialog(false)
                        selectedTime =
                            if (timePickerState.hour < 10) "0${timePickerState.hour}:${timePickerState.minute}"
                            else "${timePickerState.hour}:${timePickerState.minute}"
                        onValueChange(selectedTime)
                        openDialog = false
                    }) {
                        Text(text = "Confirm")
                    }
                }
            }
        }
    }
    OutlinedTextField(
        value = deadLineTime,
        onValueChange = { onValueChange(selectedTime) },
        trailingIcon = {
            IconButton(onClick = { openDialog = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.clock_icon),
                    contentDescription = null
                )
            }
        },
        label = { Text(text = "hour:minute") },
        modifier = Modifier.fillMaxWidth()
    )
}