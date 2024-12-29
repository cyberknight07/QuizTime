package com.example.quiztime.domain.usecases

import com.example.quiztime.common.Resource
import com.example.quiztime.domain.model.Quiz
import com.example.quiztime.domain.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetQuizUseCases @Inject constructor(val quizRepository: QuizRepository) {

    operator fun invoke(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ) : Flow<Resource<List<Quiz>>> = flow {

        emit(Resource.Loading())

        try {
            emit(Resource.Success(quizRepository.getQuiz(amount, category, difficulty, type)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}