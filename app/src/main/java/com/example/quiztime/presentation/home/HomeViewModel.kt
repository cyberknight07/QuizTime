package com.example.quiztime.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow


class HomeViewModel : ViewModel() {

    private val _homeState = MutableStateFlow(StateHomeQuiz())
    val homeState = _homeState

    fun onEvent(event : EventHomeQuiz) {
        when(event) {
            is EventHomeQuiz.SetAmount -> {
                _homeState.value = _homeState.value.copy(amount = event.amount)
            }
            is EventHomeQuiz.SetCategory -> {
                _homeState.value = _homeState.value.copy(category = event.category)
            }
            is EventHomeQuiz.SetType -> {
                _homeState.value = _homeState.value.copy(type = event.type)
            }
            is EventHomeQuiz.SetDifficulty -> {
                _homeState.value = _homeState.value.copy(difficulty = event.difficulty)
            }
            else -> {}
        }
    }


}