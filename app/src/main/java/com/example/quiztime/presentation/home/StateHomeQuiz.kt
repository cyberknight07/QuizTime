package com.example.quiztime.presentation.home

data class StateHomeQuiz (
    val amount : Int = 10,
    val category : String = "General Knowledge",
    val difficulty : String = "Easy",
    val type : String = "Multiple Choice"
)