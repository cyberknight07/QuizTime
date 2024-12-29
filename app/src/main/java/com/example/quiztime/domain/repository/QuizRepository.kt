package com.example.quiztime.domain.repository

import com.example.quiztime.domain.model.Quiz


// Quiz Repository is a interface which is implemented in Quiz Repository Impl

interface QuizRepository {

   suspend fun getQuiz(
        amount : Int,
        category : Int,
        difficulty : String,
        type : String
    ) : List<Quiz>

}