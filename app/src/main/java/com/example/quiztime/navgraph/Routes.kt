package com.example.quiztime.navgraph



const val ARG_FOR_QUESTIONS = "afg"
const val ARG_FOR_CATEGORY = "afc"
const val ARG_FOR_DIFFICULTY = "afd"
const val ARG_FOR_TYPE = "aft"

sealed class Routes(val route : String) {
    object HomeScreen : Routes("home")
    object QuizScreen : Routes("quiz/{$ARG_FOR_QUESTIONS}/{$ARG_FOR_CATEGORY}/{$ARG_FOR_DIFFICULTY}/{$ARG_FOR_TYPE}")

    fun passQuizParameters(
        amount : Int,
        category: String,
        difficulty : String,
        type: String
    ) : String {

        return "quiz/{$ARG_FOR_QUESTIONS}/{$ARG_FOR_CATEGORY}/{$ARG_FOR_DIFFICULTY}/{$ARG_FOR_TYPE}"
            .replace(
                oldValue = "{$ARG_FOR_QUESTIONS}",
                newValue = amount.toString()
            )
            .replace(
                oldValue = "{$ARG_FOR_CATEGORY}",
                newValue = category
            )
            .replace(
                oldValue = "{$ARG_FOR_TYPE}",
                newValue = type
            )
            .replace(
                oldValue = "{$ARG_FOR_DIFFICULTY}",
                newValue = difficulty
            )
    }
}