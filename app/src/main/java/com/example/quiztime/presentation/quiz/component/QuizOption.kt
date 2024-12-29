package com.example.quiztime.presentation.quiz.component

import android.R
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quiztime.common.Dimens


@Composable
@Preview
fun Option(){
    QuizOption(
        optionNumber = "1",
        optionText = "Doremon",
        selected = false,
        onOptionClicked = {},
        onUnselectedOption = {}
    )
}


@Composable
fun QuizOption(
    optionNumber : String,
    optionText : String,
    selected : Boolean,
    onOptionClicked : () -> Unit,
    onUnselectedOption : () -> Unit
) {
    val optionTextColor = if(selected) colorResource(id = R.color.darker_gray) else colorResource(R.color.black)
    val transition = updateTransition(selected, label = "selected")

    val startColor = transition.animateColor(
        transitionSpec = { tween(durationMillis = DefaultDurationMillis, easing = LinearEasing) },
        label = "startColor") { selectedBox ->
            if (selectedBox) colorResource(R.color.holo_orange_dark) else colorResource(R.color.darker_gray)
    }

    Box(
        modifier = Modifier
            .noRippleClickable(onOptionClicked)
            .fillMaxWidth()
            .height(Dimens.MediumBoxHt)
            .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
            .background(startColor.value, shape = RoundedCornerShape(Dimens.LargeCornerRadius))
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(Dimens.SmallPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(!selected) {

                Box(
                    modifier = Modifier
                        .padding(Dimens.SmallPadding)
                        .size(Dimens.SmallBoxHt)
                        .clip(CircleShape)
                        .background(color = colorResource(R.color.holo_orange_dark)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = optionNumber,
                        fontSize = Dimens.MediumTextSize,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.darker_gray),
                        textAlign = TextAlign.Center
                    )
                }

                Text(
                    text = optionText,
                    fontSize = Dimens.MediumTextSize,
                    fontWeight = FontWeight.SemiBold,
                    color = optionTextColor,
                    textAlign = TextAlign.Center
                )

            }
            else{

                Spacer(Modifier.width(Dimens.SmallBoxHt))


                    Text(
                        modifier = Modifier.fillMaxWidth(.8f),
                        text = optionText,
                        fontSize = Dimens.MediumTextSize,
                        fontWeight = FontWeight.SemiBold,
                        color = optionTextColor,
                        textAlign = TextAlign.Start
                    )

                    Box(
                        modifier = Modifier
                            .padding(Dimens.SmallPadding)
                            .size(Dimens.SmallBoxHt)
                            .clip(CircleShape)
                            .background(color = colorResource(R.color.darker_gray))


                    ) {
                        IconButton(onClick = { onUnselectedOption() }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                tint = colorResource(R.color.holo_orange_dark),
                                contentDescription = "Wrong Answer"
                            )
                        }
                    }



            }
        }

    }
}

fun Modifier.noRippleClickable(onClick : () -> Unit) : Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}