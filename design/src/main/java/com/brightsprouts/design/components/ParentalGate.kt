package com.brightsprouts.design.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brightsprouts.design.dimensions.BrightSproutsDimensions

@Composable
fun ParentalGate(
    onPassed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val a = remember { (3..9).random() }
    val b = remember { (1..5).random() }
    var input by remember { mutableStateOf("") }
    val correctAnswer = a + b
    
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = BrightSproutsDimensions.elevationL)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BrightSproutsDimensions.spacingXL),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Parents Only",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingL))
            
            Text(
                text = "What is $a + $b?",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingL))
            
            OutlinedTextField(
                value = input,
                onValueChange = { newValue ->
                    input = newValue.filter { it.isDigit() }.take(2)
                },
                label = { Text("Answer") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingL))
            
            Button(
                onClick = onPassed,
                enabled = input.toIntOrNull() == correctAnswer,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
