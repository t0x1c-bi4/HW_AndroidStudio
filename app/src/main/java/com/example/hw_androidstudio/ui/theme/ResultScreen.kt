package com.example.hw_androidstudio.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

@Composable
fun ResultScreen(correct: Int, total: Int, onRestart: () -> Unit) {

    val percent = correct * 100 / total

    val comment = when {
        percent < 50 -> "Стоит повторить материал"
        percent <= 80 -> "Хороший результат"
        else -> "Отлично!"
    }

    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text("Результат", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("$correct из $total, $percent%")
        Text(comment)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onRestart) {
            Text("Пройти ещё раз")
        }
    }
}