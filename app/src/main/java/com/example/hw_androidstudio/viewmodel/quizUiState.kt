package com.example.hw_androidstudio.viewmodel

data class quizUiState(
    val isStarted: Boolean = false,
    val currentQuestionIndex: Int = 0,
    val correctAnswers: Int = 0,
    val isFinished: Boolean = false,
    val selectedAnswerIndex: Int? = null
)