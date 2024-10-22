package com.example.rickmortyapi.ui.fragment.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmortyapi.data.network.model.Character
import com.example.rickmortyapi.data.repositories.CharacterRepository
import com.example.rickmortyapi.utils.Resource
import kotlinx.coroutines.launch

class CartoonViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableLiveData<Resource<List<Character>>>()
    val characters: LiveData<Resource<List<Character>>> get() = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            repository.getAllCharacters().observeForever {
                _characters.postValue(it)
            }
        }
    }
}