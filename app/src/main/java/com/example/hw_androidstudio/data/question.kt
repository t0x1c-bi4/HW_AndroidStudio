package com.example.hw_androidstudio.data

data class question(
    val text: String,
    val answers: List<String>,
    val correctIndex: Int
)