package com.example.quiztime.presentation.quiz.quizscreen

sealed class EventQuizScreen {
    data class GetQuiz(
        val amount : Int,
        val category : Int,
        val difficulty : String,
        val type : String
    ) : EventQuizScreen()
}