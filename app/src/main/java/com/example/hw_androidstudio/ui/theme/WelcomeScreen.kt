package com.example.hw_androidstudio.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*

@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Викторина по основам аниме", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Вам предстоит отвечать на вопросы базовой терминологии аниме культуры")
        Spacer(Modifier.height(32.dp))
        Button(onClick = onStart) {
            Text("Начать")
        }
    }
}