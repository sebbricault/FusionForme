package com.example.fusionforme.data.repository

import com.example.fusionforme.RetrofitInstance
import com.example.fusionforme.data.ExerciceKtKotlin
import com.example.fusionforme.data.entity.Exercice

class ListeExerciceRepository {
    private val fitnessService = RetrofitInstance.listExerciceService

    suspend fun getFitness(): List<ExerciceKtKotlin> {
        val fitnessResponse = fitnessService.getExercises()
        // Convertir l'objet en une liste d'un seul élément
         return fitnessResponse // Encapsuler l'objet dans une liste
    }
}