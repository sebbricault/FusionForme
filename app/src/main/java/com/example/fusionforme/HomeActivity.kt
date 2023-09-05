package com.example.fusionforme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.fusionforme.composable.Accueil

import com.example.fusionforme.data.viewModel.ListExerciceViewModel
import com.example.fusionforme.navigation.NavApp
import com.example.fusionforme.navigation.NavHost
import com.example.fusionforme.ui.theme.FusionFormeTheme
import kotlinx.coroutines.delay

class HomeActivity : ComponentActivity() {
    val viewModelFitness: ListExerciceViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FusionFormeTheme {
                NavHost(viewModelFitness)// A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun SplashScreen(navigation: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.8f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy, // Utilisation du dampingRatio élevé pour l'effet de rebond
                stiffness = Spring.StiffnessLow
            )
        )
        delay(3000L)
        navigation.navigate(NavApp.NEWS_SCREEN)
    }
    Surface(
        color = Color.Black
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .scale(scale.value)
                    .size(300.dp)
                    .clip(RoundedCornerShape(35.dp)),
                painter = painterResource(id = R.drawable.fond) ,
                contentScale=ContentScale.Crop,

                contentDescription = "Logo Event Effect",
            )
            Text(text = "FusionForm",color = Color.White)
        }
    }
}
