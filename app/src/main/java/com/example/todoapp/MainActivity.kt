package com.example.todoapp

import android.app.Application
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.components.TopBar
import com.example.todoapp.database.TaskViewModel
import com.example.todoapp.screens.BottomSheetScree
import com.example.todoapp.screens.TaskListScreen
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val taskViewModel: TaskViewModel = viewModel(
                factory = object : ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return TaskViewModel(applicationContext as Application) as  T
                    }
                }
            )
            //BottomSheet related variable
            val sheetState = rememberModalBottomSheetState()
            var sheetVisibility by rememberSaveable {
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
                            FloatingActionButton(onClick = { sheetVisibility = true }) {
                                Text(text = "+ Add")
                            }
                        }
                    ) {paddingValues ->
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)) {

                            TaskListScreen(taskViewModel)

                            Button(onClick = { sheetVisibility = true }) {
                                Text(text = "BottomSheet")
                            }
                        }
                        if(sheetVisibility) {
                            ModalBottomSheet(
                                sheetState = sheetState,
                                onDismissRequest = { sheetVisibility = false},
                            ) {
                                BottomSheetScree(taskViewModel,{sheetVisibility = it})
                            }
                        }
                    }
                }
            }
        }
    }
}