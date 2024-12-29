package com.example.quiztime.presentation.quiz.quizscreen

import com.example.quiztime.presentation.quiz.component.QuizOption


import android.R
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime.common.Dimens
import com.example.quiztime.presentation.common.ButtonBox


//@Preview(showBackground = true)
//@Composable
/*fun PrevQuiz(){
    ShimmerQuizScreen(
    )
}*/

@Composable
fun ShimmerQuizScreen(modifier: Modifier = Modifier.fillMaxSize().shimmerEffect()){
    Box(modifier = Modifier.padding(Dimens.MediumPadding), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row( modifier = Modifier.fillMaxWidth() ) {
                Text(
                    modifier = Modifier.weight(.1f),
                    text = "",
                    color = colorResource(R.color.darker_gray),
                    fontSize = Dimens.NormalTextSize,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    modifier = Modifier.weight(.9f),
                    text = "",
                    color = colorResource(R.color.darker_gray),
                    fontSize = Dimens.NormalTextSize,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(Modifier.height(Dimens.SmallSpacerHt))
            LazyColumn(modifier = Modifier.padding(horizontal = 15.dp)) {
                items(count = 4) {
                    QuizOption(
                        optionNumber = "",
                        optionText = "",
                        selected = false,
                        onOptionClicked = { },
                        onUnselectedOption = { }
                    )
                Spacer(Modifier.height(Dimens.SmallSpacerHt))
            }
            }
            Spacer(Modifier.height(Dimens.LargeSpacerHt))

            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = Dimens.MediumPadding)
                    .navigationBarsPadding()
            ) {

                ButtonBox(
                    text = "",
                    borderColor = colorResource(R.color.darker_gray),
                    textColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.darker_gray),
                    fontSize = Dimens.MediumTextSize,
                    onClick = {},
                    fraction = .5F,
                    padding = Dimens.SmallPadding
                )
                ButtonBox(
                    text = "",
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

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    ).value
    background(color = colorResource(R.color.black).copy(alpha = alpha))
}