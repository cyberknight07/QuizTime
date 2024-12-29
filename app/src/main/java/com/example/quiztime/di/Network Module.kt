package com.example.quiztime.di

import com.example.quiztime.data.remote.QuizApi
import com.example.quiztime.data.repositary.QuizRepositaryImpl
import com.example.quiztime.domain.repository.QuizRepository
import com.example.quiztime.domain.usecases.GetQuizUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    @Provides
    @Singleton
    fun provideQuizApi() : QuizApi {
        return Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApi::class.java)
    }

    @Provides
    @Singleton
    fun provideQuizRepository(quizApi: QuizApi) : QuizRepository {
        return QuizRepositaryImpl(quizApi)
    }

    @Provides
    @Singleton
    fun providesGetUseCase(quizRepository: QuizRepository) : GetQuizUseCases{
        return GetQuizUseCases(quizRepository)
    }

}