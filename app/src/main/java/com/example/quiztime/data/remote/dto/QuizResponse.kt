package com.example.quiztime.data.remote.dto

import com.example.quiztime.domain.model.Quiz

data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
)