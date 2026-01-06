package com.example.hw_androidstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.example.hw_androidstudio.ui.theme.HW_AndroidStudioTheme
import com.example.hw_androidstudio.viewmodel.quizViewModel
import com.example.hw_androidstudio.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HW_AndroidStudioTheme {
                val viewModel = remember { quizViewModel() }
                val state = viewModel.state

                when {

                    !state.isStarted -> {
                        WelcomeScreen(onStart = { viewModel.startQuiz() })
                    }

                    state.isFinished -> {
                        ResultScreen(
                            correct = state.correctAnswers,
                            total = com.example.hw_androidstudio.data.quizRepository.questions.size,
                            onRestart = { viewModel.restart() }
                        )
                    }

                    else -> {
                        val question = com.example.hw_androidstudio.data.quizRepository.questions[state.currentQuestionIndex]

                        QuestionScreen(
                            questionText = question.text,
                            answers = question.answers,
                            selectedAnswer = state.selectedAnswerIndex,
                            questionNumber = "Вопрос ${state.currentQuestionIndex + 1} из ${com.example.hw_androidstudio.data.quizRepository.questions.size}",
                            onAnswerSelected = { viewModel.selectAnswer(it) },
                            onNext = { viewModel.nextQuestion() }
                        )
                    }
                }
            }
        }
    }
}