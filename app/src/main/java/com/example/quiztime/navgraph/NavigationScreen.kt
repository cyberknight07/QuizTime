package com.example.quiztime.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quiztime.presentation.home.HomeScreen
import com.example.quiztime.presentation.home.HomeViewModel
import com.example.quiztime.presentation.quiz.quizscreen.QuizScreen
import com.example.quiztime.presentation.quiz.quizscreen.QuizViewModel

@Composable
fun NavigationScreen(){
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Routes.HomeScreen.route) {
        composable(Routes.HomeScreen.route) {

            val viewModel : HomeViewModel = hiltViewModel()
            val state = viewModel.homeState.collectAsState()
            HomeScreen(
                state = state.value,
                event = viewModel::onEvent,
                navHostController
            )
        }

        composable(
            route = Routes.QuizScreen.route,
            arguments = listOf(
                navArgument(ARG_FOR_QUESTIONS){type = NavType.IntType},
                navArgument(ARG_FOR_CATEGORY){type = NavType.StringType},
                navArgument(ARG_FOR_DIFFICULTY){type = NavType.StringType},
                navArgument(ARG_FOR_TYPE){type = NavType.StringType}
            )
        ) {
            val amount = it.arguments?.getInt(ARG_FOR_QUESTIONS)
            val category = it.arguments?.getString(ARG_FOR_CATEGORY)
            val difficulty = it.arguments?.getString(ARG_FOR_DIFFICULTY)
            val type = it.arguments?.getString(ARG_FOR_TYPE)

            val viewModel : QuizViewModel = hiltViewModel()
            val state = viewModel.quizStateList.collectAsState()
            QuizScreen(
                amount = amount!!,
                category = category!!,
                difficulty = difficulty!!,
                type = type!!,
                state = state.value,
                event =  viewModel::onEvent,
            )

        }
    }
}