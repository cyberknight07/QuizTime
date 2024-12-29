package com.example.quiztime.presentation.home

sealed class EventHomeQuiz {
    data class SetAmount(val amount: Int) : EventHomeQuiz()
    data class SetCategory(val category : String) : EventHomeQuiz()
    data class SetDifficulty(val difficulty: String) : EventHomeQuiz()
    data class SetType(val type : String) : EventHomeQuiz()
}