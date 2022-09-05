package com.dicoding.jetkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dicoding.jetkotlin.ui.theme.JetKotlinTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetKotlinTheme {
        CounterApp()
    }
}

@Composable
fun CounterApp() {
    Column {
        var number by remember { //delegated properties
            mutableStateOf(0)
        }
        MyButton { number += 1 }
        Text(
            text = number.toString(), //named argument
            modifier = Modifier.align(Alignment.CenterHorizontally), //scope & receiver
            style = MaterialTheme.typography.h2, //singleton object
            fontStyle = FontStyle.Italic, //trailing comma
        )
        LazyRow { //DSL
            item { Text("No:") }
            items(number){
                Text("${it+1}")
            }
        }
    }
}

@Composable
fun MyButton(onButtonClicked: () -> Unit) { //high order function
    Button(onClick = onButtonClicked) { //lambda experession
        Text("Click Me")
    }
}