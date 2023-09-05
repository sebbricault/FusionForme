package com.example.fusionforme

import Profil
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.fusionforme.data.viewModel.ProfilViewModel
import com.example.fusionforme.ui.theme.FusionFormeTheme

class FormProfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FusionFormeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }
    val height = remember { mutableStateOf("") }

    val selectedMenuItem = remember { mutableStateOf("") }
    val menuExpanded = remember { mutableStateOf(false) }
    val profileVModel = viewModel<ProfilViewModel>()

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f)))
        Image(
            painter = painterResource(id = R.drawable.fond),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Nom") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )

            TextField(
                value = age.value,
                onValueChange = { age.value = it },
                label = { Text("Âge") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )

            TextField(
                value = weight.value,
                onValueChange = { weight.value = it },
                label = { Text("Poids (kg)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )

            TextField(
                value = height.value,
                onValueChange = { height.value = it },
                label = { Text("Taille (cm)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )


            Column(modifier = Modifier.padding(bottom = 6.dp)) {
                TextButton(
                    onClick = { menuExpanded.value = !menuExpanded.value },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFECEFF1))
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Niveau",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                DropdownMenu(
                    expanded = menuExpanded.value,
                    onDismissRequest = { menuExpanded.value = false },  modifier = Modifier.fillMaxWidth().padding(6.dp),

                ) {
                    DropdownMenuItem(
                        text = { Text("Débutant") },
                        onClick = {
                            Toast.makeText(context, "Débutant", Toast.LENGTH_SHORT)
                                .show(); selectedMenuItem.value = "Débutant";menuExpanded.value = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Intérmediaire") },
                        onClick = {
                            Toast.makeText(context, "Intérmediaire", Toast.LENGTH_SHORT)
                                .show(); selectedMenuItem.value = "Intérmediaire";menuExpanded.value = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Expert") },
                        onClick = {
                            Toast.makeText(context, "Expert", Toast.LENGTH_SHORT)
                                .show(); selectedMenuItem.value = "Expert";menuExpanded.value = false
                        }
                    )
                }
            }

            Button(
                onClick = {
                    profileVModel.insertProfil(
                        Profil(
                            name = name.value,
                            age = age.value,
                            poid = weight.value,
                            taille = height.value,
                            niveau = selectedMenuItem.value
                        )
                    )
                    },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Enregistrer")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    FusionFormeTheme {
        Greeting2()
    }
}