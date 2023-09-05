package com.example.fusionforme.data.entity

data class Exercice( val id: String,
                     val name: String,
                     val description: String,
                     val force: String,
                     val level: String,
                     val mechanic: String,
                     val equipment: String,
                     val primaryMuscles: List<String>,
                     val secondaryMuscles: List<String>,
                     val instructions: List<String>,
                     val category: String,
                     val images: List<String>)
