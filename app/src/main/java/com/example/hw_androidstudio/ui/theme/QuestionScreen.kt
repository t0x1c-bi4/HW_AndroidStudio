package com.example.hw_androidstudio.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

@Composable
fun QuestionScreen(
    questionText: String,
    answers: List<String>,
    selectedAnswer: Int?,
    questionNumber: String,
    onAnswerSelected: (Int) -> Unit,
    onNext: () -> Unit
) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {

        Text(questionNumber)
        Spacer(Modifier.height(12.dp))
        Text(questionText, style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        answers.forEachIndexed { index, text ->
            Row {
                RadioButton(
                    selected = selectedAnswer == index,
                    onClick = { onAnswerSelected(index) }
                )
                Text(text)
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onNext,
            enabled = selectedAnswer != null
        ) {
            Text("Дальше")
        }
    }
}