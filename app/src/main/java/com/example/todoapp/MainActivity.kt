package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.todoapp.components.TopBar
import com.example.todoapp.screens.BottomSheetScree
import com.example.todoapp.screens.TaskListScreen
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //BottomSheet related variable
            val sheetState = rememberModalBottomSheetState()
            var sheetVisibility = rememberSaveable {
                mutableStateOf(false)
            }

            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { TopBar()},
                        floatingActionButton = {
                            FloatingActionButton(onClick = { sheetVisibility.value = true }) {
                                Text(text = "+ Add")
                            }
                        }
                    ) {paddingValues ->
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)) {

                            TaskListScreen()

                            Button(onClick = { sheetVisibility.value = true }) {
                                Text(text = "BottomSheet")
                            }
                        }
                        if(sheetVisibility.value) {
                            ModalBottomSheet(
                                sheetState = sheetState,
                                onDismissRequest = { sheetVisibility.value = false},
                            ) {
                                BottomSheetScree()
                            }
                        }
                    }
                }
            }
        }
    }
}