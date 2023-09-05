package com.example.fusionforme.data.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fusionforme.data.ExerciceKtKotlin
import com.example.fusionforme.data.entity.Exercice
import com.example.fusionforme.data.repository.ListeExerciceRepository
import kotlinx.coroutines.launch

class ListExerciceViewModel:ViewModel() {

    private val repository = ListeExerciceRepository()

    private val _ListExercice = MutableLiveData<List<ExerciceKtKotlin>>()
    val ListExercice: LiveData<List<ExerciceKtKotlin>> = _ListExercice

    fun fetchListExercice() {
        viewModelScope.launch {
            try {
                val exerciceList = repository.getFitness()
                _ListExercice.value = exerciceList // Utiliser directement la liste
                Log.d("FetchListExercice", _ListExercice.value.toString())
            } catch (e: Exception) {
                // Gérer l'erreur
                Log.e("FetchListExercice", e.message.toString())
            }
        }
    }
}
