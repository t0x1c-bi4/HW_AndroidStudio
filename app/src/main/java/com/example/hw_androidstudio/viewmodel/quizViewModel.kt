package com.example.hw_androidstudio.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hw_androidstudio.data.quizRepository

class quizViewModel : ViewModel() {
    private val questions = quizRepository.questions

    var state by mutableStateOf(quizUiState())
        private set

    fun selectAnswer(index: Int) {
        state = state.copy(selectedAnswerIndex = index)
    }

    fun nextQuestion() {
        val isCorrect = state.selectedAnswerIndex == questions[state.currentQuestionIndex].correctIndex

        val newCorrect = if (isCorrect) state.correctAnswers + 1 else state.correctAnswers

        if (state.currentQuestionIndex + 1 < questions.size) {
            state = state.copy(
                currentQuestionIndex = state.currentQuestionIndex + 1,
                correctAnswers = newCorrect,
                selectedAnswerIndex = null
            )
        } else {
            state = state.copy(
                correctAnswers = newCorrect,
                isFinished = true
            )
        }
    }

    fun restart() {
        state = quizUiState()
    }

    fun startQuiz() {
        state = state.copy(isStarted = true)
    }

}