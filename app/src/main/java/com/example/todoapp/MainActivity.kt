package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.TodoAppTheme
import com.example.todoapp.ui.theme.blackFont
import com.example.todoapp.ui.theme.topBarColor
import com.example.todoapp.ui.theme.whiteContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { TopBar()},
                        floatingActionButton = { FloatinActionBtn()},
                        floatingActionButtonPosition = FabPosition.End
                    ) {paddingValues ->
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)) {
                            Text(text = "HomeScreen")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FloatinActionBtn() {
    FloatingActionButton(
        onClick = {  },
        containerColor = whiteContainer,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "Add Task",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = blackFont,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Todo") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = topBarColor
        )
    )
}