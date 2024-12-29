package com.example.quiztime.data.repositary

import com.example.quiztime.data.remote.QuizApi
import com.example.quiztime.domain.model.Quiz
import com.example.quiztime.domain.repository.QuizRepository

class QuizRepositaryImpl(
    private val quizApi: QuizApi
) : QuizRepository {

    override suspend fun getQuiz(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Quiz> {
        return quizApi.getQuiz(
            amount,category,difficulty,type
        ).results
    }


}