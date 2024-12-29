package com.example.quiztime.presentation.common

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.quiztime.common.Dimens
import com.example.quiztime.common.Dimens.LargeCornerRadius

@Preview
@Composable
fun ButtonBox(
    text : String = "Previous",
    padding : Dp = Dimens.LargePadding,
    borderColor : Color = colorResource(id = R.color.darker_gray),
    textColor: Color = colorResource(id = R.color.holo_orange_light),
    containerColor: Color = colorResource(id = R.color.darker_gray),
    fontSize : TextUnit = Dimens.MediumTextSize,
    onClick : () -> Unit = {},
    fraction : Float = 1f
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(fraction)
            .padding(padding)
            .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
            .border(width = 3.dp, color = borderColor)
            .background(containerColor, shape = RoundedCornerShape(LargeCornerRadius))
            .padding(padding),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }

}