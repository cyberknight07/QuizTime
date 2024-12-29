package com.example.quiztime.presentation.quiz.component

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quiztime.common.Dimens

@Composable
fun QuizHeader(
    numberOfQuestions : Int,
    difficulty : String
){
    Row(
        modifier = Modifier.fillMaxWidth().padding(Dimens.MediumPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text =  " Questions: $numberOfQuestions",
            fontSize = Dimens.SmallTextSize,
            color = colorResource(id = R.color.black),
            textAlign = TextAlign.Center
        )
        Text(
            text = difficulty,
            fontSize = Dimens.SmallTextSize,
            color = colorResource(id = R.color.black),
            textAlign = TextAlign.Center
        )
    }
    HorizontalDivider(thickness = 2.dp)
}

