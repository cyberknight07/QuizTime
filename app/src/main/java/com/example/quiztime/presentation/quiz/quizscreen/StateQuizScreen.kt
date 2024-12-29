package com.example.quiztime.presentation.quiz.quizscreen

import com.example.quiztime.domain.model.Quiz

data class StateQuizScreen(
    val isLoading : Boolean = false,
    val data : List<Quiz> ? = listOf(),
    val error : String = ""
)
