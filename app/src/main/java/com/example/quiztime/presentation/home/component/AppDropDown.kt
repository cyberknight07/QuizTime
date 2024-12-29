package com.example.quiztime.presentation.home.component

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.quiztime.common.Dimens
import com.example.quiztime.ui.theme.Typography
import kotlin.collections.forEachIndexed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDropDown(
    menuName : String,
    menuList : List<String>,
    text : String,
    onClickEvent : (String)-> Unit
){

    var isExpanded = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = Dimens.MediumPadding)
    ) {
        Text(
            text = menuName,
            style = Typography.titleMedium,
            fontWeight = FontWeight.Companion.Medium,
            color = colorResource(R.color.black)
        )
        Spacer(Modifier.height(Dimens.SmallSpacerHt))

        // Expanded Drop down menu
        ExposedDropdownMenuBox(
            expanded = isExpanded.value,
            onExpandedChange = { isExpanded.value = !isExpanded.value }
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().menuAnchor(),
                value = text,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded.value)
                },
                shape = RoundedCornerShape(Dimens.MediumCornerRadius),

                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = colorResource(id = R.color.darker_gray),
                    focusedTextColor = colorResource(R.color.darker_gray),
                    unfocusedTrailingIconColor = colorResource(R.color.darker_gray),
                    focusedTrailingIconColor = colorResource(R.color.darker_gray),
                    focusedContainerColor = colorResource(R.color.darker_gray)
                )
            )
            DropdownMenu(
                expanded = isExpanded.value,
                onDismissRequest = { isExpanded.value = false },
                modifier = Modifier.clip(
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(
                        Dimens.MediumCornerRadius
                    )
                ).fillMaxWidth().background(colorResource(R.color.white))
            ) {
                menuList.forEachIndexed { index: Int, text: String ->
                    DropdownMenuItem(
                        text = { Text(text, color = colorResource(R.color.black)) },
                        onClick = {
                            onClickEvent(menuList[index])
                            isExpanded.value = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}