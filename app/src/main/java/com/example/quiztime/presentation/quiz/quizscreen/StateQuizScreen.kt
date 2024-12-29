package com.example.quiztime.presentation.quiz.quizscreen

import com.example.quiztime.domain.model.Quiz

data class StateQuizScreen(
    val isLoading : Boolean = false,
    val qsData : List<QuizState> ? = emptyList(),
    val error : String = ""
)

data class QuizState(
    val quiz : Quiz ? = null,
    val shuffleOptions : List<String> ? = emptyList(),
    val selectedOption : Int ? = -1
)