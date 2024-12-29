package com.example.quiztime.presentation.quiz.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizTopBar(
    title : String,
    navigationIcon : @Composable () -> Unit
){
    TopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(),
        navigationIcon = navigationIcon
    )

}