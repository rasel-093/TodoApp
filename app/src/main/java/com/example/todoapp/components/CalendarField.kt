package com.example.todoapp.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.getDateInFormat
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarField(deadLineDate: String, onValueChange: (String) -> Unit) {
    var openDialog by rememberSaveable {
        mutableStateOf(false)
    }
    var selectedDate by rememberSaveable {
        mutableStateOf("")
    }
    if (openDialog) {
        //CustomDatePicker({ selectedDate = it }, { openDialog = it })
        val context = LocalContext.current

        val datePickerState = rememberDatePickerState(
            yearRange = IntRange(2023, 2030),
            initialDisplayMode = DisplayMode.Picker
        )

        DatePickerDialog(
            onDismissRequest = { },
            confirmButton = {
                Button(onClick = {
                    if (datePickerState.selectedDateMillis != null) {
                        val dateMillis = datePickerState.selectedDateMillis
                        val formattedDate = getDateInFormat(dateMillis!!)
                        selectedDate = formattedDate.format(DateTimeFormatter.ofPattern("dd/MM/yy"))
                        onValueChange(selectedDate)
                        openDialog = false
                    } else {
                        Toast.makeText(context, "Please select date", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                Button(onClick = { openDialog = false }) {
                    Text(text = "Cancel")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    OutlinedTextField(
        value = deadLineDate,
        onValueChange = { onValueChange(selectedDate) },
        trailingIcon = {
            IconButton(onClick = { openDialog = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = null
                )
            }
        },
        label = { Text(text = "date/month/year") },
        modifier = Modifier.fillMaxWidth()
    )
}