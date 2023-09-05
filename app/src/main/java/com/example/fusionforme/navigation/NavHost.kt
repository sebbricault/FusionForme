package com.example.fusionforme.navigation
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fusionforme.Greeting2
import com.example.fusionforme.Greeting3
import com.example.fusionforme.Greeting4
import com.example.fusionforme.ProfileScreen
import com.example.fusionforme.SplashScreen
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.fusionforme.composable.Accueil
import com.example.fusionforme.data.viewModel.ListExerciceViewModel
import com.example.fusionforme.data.viewModel.ProfilViewModel

@Composable
fun NavHost(viewModelFitness:ListExerciceViewModel){

    val navController = rememberNavController()
    NavHost(
        navController = navController,

        startDestination = NavApp.SPLASH_SCREEN
    ) {
        composable(NavApp.NEWS_SCREEN) {  Accueil(navigation = navController,)}
        composable(NavApp.SPLASH_SCREEN){ SplashScreen(navigation = navController)}
        composable(NavApp.HOME_SCREEN){ ProfileScreen(navigation = navController)}
        composable(NavApp.HOMEPROF_SCREEN){ Greeting3(navigation = navController)}
        composable(NavApp.FORM_SCREEN){ Greeting2()}
        composable(NavApp.ADD_SCREEN){ Greeting4(viewModelFitness=viewModelFitness) }


    }
    }
