package com.example.calculator.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.CalculatorButton

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    val currentTextState = remember { mutableStateOf("") }
    Column(modifier.fillMaxSize()) {
        // Result part
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .background(Color.Green)
        ) {
            Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.End) {
                Text(
                    text = "Result Text",
                    Modifier.padding(top = 50.dp, end = 20.dp),
                    fontSize = 25.sp
                )
                Text(
                    text = currentTextState.value,
                    Modifier.padding(top = 30.dp, end = 20.dp),
                    fontSize = 20.sp
                )
            }
        }
        // buttons part
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Red)
        ) {
            CalculatorButtons(modifier = Modifier, currentTextState)
        }
    }
}

@Composable
fun CalculatorButtons(modifier: Modifier = Modifier, state: MutableState<String>) {
    val buttonsList = arrayListOf<CalculatorButton>()
    buttonsList.add(CalculatorButton("AC") {     })
    buttonsList.add(CalculatorButton("Root") {     })
    buttonsList.add(CalculatorButton("%") { state.value += "%" })
    buttonsList.add(CalculatorButton("/") { state.value += "/" })
    buttonsList.add(CalculatorButton("7") { state.value += "7" })
    buttonsList.add(CalculatorButton("8") { state.value += "8" })
    buttonsList.add(CalculatorButton("9") { state.value += "9" })
    buttonsList.add(CalculatorButton("X") { state.value += "X" })
    buttonsList.add(CalculatorButton("4") { state.value += "4" })
    buttonsList.add(CalculatorButton("5") { state.value += "5" })
    buttonsList.add(CalculatorButton("6") { state.value += "6" })
    buttonsList.add(CalculatorButton("-") { state.value += "-" })
    buttonsList.add(CalculatorButton("1") { state.value += "1" })
    buttonsList.add(CalculatorButton("2") { state.value += "2" })
    buttonsList.add(CalculatorButton("3") { state.value += "3" })
    buttonsList.add(CalculatorButton("+") { state.value += "+" })
    buttonsList.add(CalculatorButton("0") { state.value += "0" })
    buttonsList.add(CalculatorButton(".") { state.value += "." })  // NEED SPECIFIC LOGIC FOR THIS KIND OF ITEMS FOR 2nd TIME CLICK
    buttonsList.add(CalculatorButton("D") {})
    buttonsList.add(CalculatorButton("=") {})
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        itemsIndexed(items = buttonsList) { _, customItem ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = customItem.onClick, modifier = modifier.size(65.dp)) {
                    Text(
                        text = customItem.text,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}