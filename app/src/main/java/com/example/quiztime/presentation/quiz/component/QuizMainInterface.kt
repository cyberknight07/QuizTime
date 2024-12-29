package com.example.quiztime.presentation.quiz.component

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime.common.Dimens


@Preview(showBackground = true)
@Composable
fun PrevQuiz(){
    QuizMainInterface(
        {}, 1
    )
}

@Composable
fun QuizMainInterface(
    onOptSelected : (Int) -> Unit,
    questionNumber : Int,
    modifier : Modifier = Modifier
){
    Box(modifier = modifier.padding(Dimens.MediumPadding), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row( modifier = Modifier.fillMaxWidth() ) {
                Text(
                    modifier = Modifier.weight(.1f),
                    text = "$questionNumber",
                    color = colorResource(R.color.darker_gray),
                    fontSize = Dimens.NormalTextSize,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    modifier = Modifier.weight(.9f),
                    text = "What is your favourite cartoon?",
                    color = colorResource(R.color.darker_gray),
                    fontSize = Dimens.NormalTextSize,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(Modifier.height(Dimens.SmallSpacerHt))
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                val options = listOf(
                    "A" to "Doraemon",
                    "B" to "Shinchan",
                    "C" to "Ninja Hattori",
                    "D" to "Pokemon"
                )

                options.forEachIndexed { index, (optionIndex : String, optionText: String) ->
                    if(optionText.isNotEmpty()){
                        QuizOption(
                            optionNumber = optionIndex,
                            optionText = optionText,
                            selected = false,
                            onOptionClicked = { onOptSelected(index) },
                            onUnselectedOption = { onOptSelected(-1) }
                        )
                    }
                    Spacer(Modifier.height(Dimens.SmallSpacerHt))
                }
            }

        }
    }

}