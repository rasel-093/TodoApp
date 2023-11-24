package com.example.todoapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.blackFont
import com.example.todoapp.ui.theme.primaryColor

@Composable
fun BottomSheetScree() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
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
        Text(
            text = "New Task",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = blackFont
        )
        TextField(text = title, onValueChange = {title = it},"Title",
            KeyboardOptions(imeAction = ImeAction.Next)
        )
        TextField(text = details, onValueChange = {details = it},"Details",
            KeyboardOptions(imeAction = ImeAction.Next)
        )
        TextField(text = deadLineDate, onValueChange = {deadLineDate = it},"Deadline Date",
            KeyboardOptions(imeAction = ImeAction.Next)
        )
        TextField(text = deadlineTime, onValueChange ={deadlineTime = it}, "DeadLine Time",
            KeyboardOptions(imeAction = ImeAction.Done) )

        Spacer(modifier = Modifier.height(20.dp))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(0.7f)
        ){
            Button(
                onClick = { /*TODO*/ },
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
                onClick = { /*TODO*/ },
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

@Composable
fun TextField(text: String, onValueChange: (String)-> Unit, label: String,keyBoardAction: KeyboardOptions) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = label)},
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyBoardAction
    )
}