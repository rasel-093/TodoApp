package com.example.todoapp.screens

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.components.BoldText
import com.example.todoapp.components.CalendarField
import com.example.todoapp.components.CustomTextField
import com.example.todoapp.components.TimeField
import com.example.todoapp.database.TaskItem
import com.example.todoapp.database.TaskViewModel
import com.example.todoapp.ui.theme.blackFont
import com.example.todoapp.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AddTaskDialogScreen(
    taskViewModel: TaskViewModel, isDialogVisible: (Boolean) -> Unit
) {
    val context = LocalContext.current
    AlertDialog(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White),
        onDismissRequest = { /*TODO*/ },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var title by rememberSaveable {
                mutableStateOf("")
            }
            var details by rememberSaveable {
                mutableStateOf("")
            }
            var deadlineTime by rememberSaveable {
                mutableStateOf("")
            }
            var deadLineDate by rememberSaveable {
                mutableStateOf("")
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    BoldText(text = "New Task")
                    CustomTextField(
                        text = title, onValueChange = { title = it }, "Title",
                        KeyboardOptions(imeAction = ImeAction.Next)
                    )
                    CustomTextField(
                        text = details, onValueChange = { details = it }, "Details",
                        KeyboardOptions(imeAction = ImeAction.Next)
                    )
                    CalendarField(deadLineDate) { deadLineDate = it }
                    TimeField(deadlineTime) { deadlineTime = it }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Button(
                    onClick = {
                        isDialogVisible(false)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor
                    )
                ) {
                    Text(
                        text = "Cancel",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = blackFont
                    )
                }
                Button(
                    onClick = {
                        if (title.isNotEmpty() && deadLineDate.isNotEmpty() && deadlineTime.isNotEmpty()){
                            val taskItem = TaskItem(
                                null,
                                title,
                                details,
                                (false).toString(),
                                deadLineDate,
                                deadlineTime

                            )
//                        Log.d("Deadline date", deadLineDate)
//                        Log.d("Deadline time", deadlineTime)
                            taskViewModel.inserTask(taskItem)
                            isDialogVisible(false)
                        }else{
                            Toast.makeText(context, "Please fill up all fields", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor
                    )
                ) {
                    Text(
                        text = "Save",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = blackFont
                    )
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}