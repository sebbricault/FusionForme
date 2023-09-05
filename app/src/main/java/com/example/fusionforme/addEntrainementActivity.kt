package com.example.fusionforme

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fusionforme.data.viewModel.ListExerciceViewModel
import com.example.fusionforme.ui.theme.FusionFormeTheme
import kotlinx.coroutines.delay

class addEntrainementActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FusionFormeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Greeting4( modifier: Modifier = Modifier,viewModelFitness:ListExerciceViewModel) {

    val fitness by viewModelFitness.ListExercice.observeAsState(null)
    var currentImageIndex = remember { mutableStateOf(0) }

    val lazyListState = rememberLazyListState()



    LaunchedEffect(lazyListState) {
        viewModelFitness.fetchListExercice()
        while (true) {
            delay(1000L)
            currentImageIndex.value = (currentImageIndex.value + 1) % 2
        }
    }
    if (fitness== null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )
            Image(
                painter = painterResource(id = R.drawable.fond),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp)
            )
        }
    }else {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )
            Image(
                painter = painterResource(id = R.drawable.fond),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )
            LazyColumn(modifier = Modifier.fillMaxSize(), state = lazyListState) {
                items(fitness!!) { news ->

                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(240.dp),

                    ) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Box(
                                Modifier.fillMaxSize()
                                    .clickable { /* Action lorsque la carte est cliquée */ }) {
                                AsyncImage(
                                    model = "https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/exercises/${
                                        news.name.orEmpty().replace(" ", "_").replace("/", "_")
                                            .replace("(", "").replace(")", "")
                                    }/${currentImageIndex.value}.jpg",
                                    contentDescription = "Exercise Image",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier.fillMaxSize()
                                )

                                Column(
                                    modifier = Modifier
                                        .padding(16.dp),
                                            verticalArrangement = Arrangement.Bottom,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = news.name.orEmpty(),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White


                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    FusionFormeTheme {

    }
}