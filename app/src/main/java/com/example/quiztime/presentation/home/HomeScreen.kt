@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.quiztime.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.quiztime.common.Constants
import com.example.quiztime.common.Dimens
import com.example.quiztime.navgraph.Routes
import com.example.quiztime.presentation.home.component.AppDropDown

@Composable
fun HomeScreen(
    state : StateHomeQuiz,
    event : (EventHomeQuiz) -> Unit,
    navController: NavHostController
){

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Quiz Time") })
        }
    ) {
        Column(Modifier.padding(it), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(Modifier.height(Dimens.MediumSpacerHt))
            AppDropDown(
                menuName = "Number Of Question",
                menuList = Constants.numbersAsString,
                text = state.amount.toString(),
                onClickEvent = {event(EventHomeQuiz.SetAmount(it.toInt()))}
            )
            Spacer(Modifier.height((Dimens.SmallSpacerHt)))
            AppDropDown(
                menuName = "Category",
                menuList = Constants.categories,
                text = state.category,
                onClickEvent = {event(EventHomeQuiz.SetCategory(it))}
            )
            Spacer(Modifier.height((Dimens.SmallSpacerHt)))
            AppDropDown(
                menuName = "Difficulty",
                menuList = Constants.difficulty,
                text = state.difficulty,
                onClickEvent = {event(EventHomeQuiz.SetDifficulty(it))}
            )
            Spacer(Modifier.height((Dimens.SmallSpacerHt)))
            AppDropDown(
                menuName = "Type",
                menuList = Constants.type,
                text = state.type,
                onClickEvent = {event(EventHomeQuiz.SetType(it))}
            )

            ElevatedButton(
                onClick = {
                    Log.d("QQQ","${ state.amount }, ${ state.category }, ${ state.difficulty }, ${ state.type }")
                    navController.navigate(route = Routes.QuizScreen.passQuizParameters(state.amount, state.category, state.difficulty, state.type))
                }
            ) {
                Text("Generate Quiz")
            }
        }
    }

}