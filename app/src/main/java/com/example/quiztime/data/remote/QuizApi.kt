package com.example.quiztime.data.remote

import com.example.quiztime.data.remote.dto.QuizResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {

    @GET("api.php")
    fun getQuiz(
        @Query("amount") amount : Int = 10,
        @Query("category") category : Int = 10,
        @Query("difficulty") difficulty : String = "meduim" ,
        @Query("type") type : String = "boolean"
    ) : QuizResponse
}