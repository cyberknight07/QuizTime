package com.example.quiztime.presentation.quiz.quizscreen

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quiztime.common.Constants
import com.example.quiztime.common.Dimens
import com.example.quiztime.presentation.common.ButtonBox
import com.example.quiztime.presentation.quiz.component.QuizHeader
import com.example.quiztime.presentation.quiz.component.QuizMainInterface
import com.example.quiztime.presentation.quiz.component.QuizTopBar

/*@Preview(showBackground = true)
@Composable
fun PreviewQuizView(){
    QuizScreen(
        amount = 10,
        category = "GK",
        difficulty = "EASY",
        type = "e",
        state = StateQuizScreen(),
        event = {},
    )
}*/

@Composable
fun QuizScreen(
    amount : Int,
    category : String,
    difficulty : String,
    type : String,
    state : StateQuizScreen,
    event : (EventQuizScreen) -> Unit,
){

    LaunchedEffect(key1 = Unit) {
        val difficultyLevel = when(difficulty){
            "Medium" -> "medium"
            "Hard" -> "hard"
            else -> "easy"
        }
        val typeT = when(type){
            "Multiple Choice" -> "multiple"
            else -> "boolean"
        }
        event(EventQuizScreen.GetQuiz(amount, Constants.categoriesMap[category]!!, difficultyLevel, typeT))
    }


    Column(
        Modifier.fillMaxSize()
    ) {
        QuizTopBar(
            category,
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                }
            }
        )
        Spacer(Modifier.height(Dimens.MediumSpacerHt))
        QuizHeader(
            numberOfQuestions = amount,
            difficulty = difficulty
        )
        Spacer(Modifier.height(Dimens.SmallSpacerHt))

        if(quizFetched(state = state)) {

            QuizMainInterface(
                onOptSelected = {},
                questionNumber = 1,
                modifier = Modifier.weight(1f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = Dimens.MediumPadding)
                    .navigationBarsPadding()
            ) {

                ButtonBox(
                    text = "Previous",
                    borderColor = colorResource(R.color.darker_gray),
                    textColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.darker_gray),
                    fontSize = Dimens.MediumTextSize,
                    onClick = {},
                    fraction = .47F,
                    padding = Dimens.SmallPadding
                )
                ButtonBox(
                    text = "Next",
                    borderColor = colorResource(R.color.darker_gray),
                    textColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.darker_gray),
                    fontSize = Dimens.MediumTextSize,
                    onClick = {},
                    fraction = 1F,
                    padding = Dimens.SmallPadding
                )

            }
        }

    }
}


@Composable
fun quizFetched(state: StateQuizScreen) : Boolean {

    return when {
        state.isLoading -> {
            ShimmerQuizScreen()
            false
        }
        state.qsData?.isNotEmpty() == true -> {
            true
        }

        else -> {
            Text(state.error.toString())
            false
        }
    }
}