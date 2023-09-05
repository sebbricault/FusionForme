package com.example.fusionforme.Service

import com.example.fusionforme.data.ExerciceKtKotlin
import com.example.fusionforme.data.entity.Exercice
import retrofit2.http.GET

interface ListExerciceService {
    @GET("yuhonas/free-exercise-db/raw/main/dist/exercises.json")
    suspend fun getExercises(): List<ExerciceKtKotlin>
}