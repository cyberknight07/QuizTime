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
                        val listOfQSdata : List<QuizState> = getListOfQuizStateData(it.data)
                        _quizStateList.value = StateQuizScreen(qsData = listOfQSdata)
                    }
                    is Resource.Error -> {
                        _quizStateList.value = StateQuizScreen(error = it.message.toString())
                    }
                    else -> {}
                }
            }
        }
    }
    private fun getListOfQuizStateData(data: List<Quiz>?) : List<QuizState>{

        val listOfQSdata = mutableListOf<QuizState>()

        for(quiz : Quiz in data!!) {

            val shuffleOptions = mutableListOf<String>().apply {
                add(quiz.correct_answer)
                addAll(quiz.incorrect_answers)
                shuffle()
            }
            listOfQSdata.add(QuizState(quiz, shuffleOptions, -1))
        }
        return listOfQSdata
    }
}
