package com.example.quiztime.presentation.quiz.quizscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiztime.common.Resource
import com.example.quiztime.domain.model.Quiz
import com.example.quiztime.domain.usecases.GetQuizUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(val getQuizUseCases: GetQuizUseCases) : ViewModel() {
    private val _quizStateList = MutableStateFlow(StateQuizScreen())
    val quizStateList = _quizStateList

    fun onEvent(event : EventQuizScreen){
        when( event){

            is EventQuizScreen.GetQuiz -> {
                getQuiz(event.amount, event.category, event.difficulty, event.type)
            }

            else -> {}
        }
    }

    fun getQuiz(amount : Int, category : Int, difficulty : String, type : String) {
        viewModelScope.launch {
            getQuizUseCases(amount,category,difficulty,type).collect {
                when(it){
                    is Resource.Loading-> {
                        Log.d("loading", " Loading True")
                        _quizStateList.value = StateQuizScreen(isLoading = true)
                    }
                    is Resource.Success -> {
                        Log.d("Succes", "Success")
                        for(quiz : Quiz in it.data!!){
                            Log.d("Quizzz", quiz.toString())
                        }
                        _quizStateList.value = StateQuizScreen(data = it.data)
                    }
                    is Resource.Error -> {
                        _quizStateList.value = StateQuizScreen(error = it.message.toString())
                    }
                    else -> {}
                }
            }
        }
    }
}