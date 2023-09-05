package com.example.fusionforme.data.viewModel

import Profil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fusionforme.data.repository.ProfilRepository
import kotlinx.coroutines.launch

class ProfilViewModel(private val repository: ProfilRepository) : ViewModel() {

    private val _profilList = MutableLiveData<List<Profil>>()
    val profilList: LiveData<List<Profil>> get() = _profilList

    fun getProfils() {
        viewModelScope.launch {
            val profils = repository.getAllProfils()
            _profilList.postValue(profils)
        }
    }

    fun insertProfil(profil: Profil) {
        viewModelScope.launch {
            repository.insertProfil(profil)
        }
    }

    fun updateProfil(profil: Profil) {
        viewModelScope.launch {
            repository.updateProfil(profil)
        }
    }

    fun deleteProfil(id: String) {
        viewModelScope.launch {
            repository.deleteProfil(id)
        }
    }
}
