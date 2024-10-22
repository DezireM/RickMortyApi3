package com.example.rickmortyapi.ui.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmortyapi.data.network.model.Character
import com.example.rickmortyapi.data.repositories.CharacterRepository
import com.example.rickmortyapi.utils.Resource
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _characterDetails = MutableLiveData<Resource<Character>>()
    val characterDetails: LiveData<Resource<Character>> get() = _characterDetails

    fun fetchCharacterDetails(characterId: Int) {
        viewModelScope.launch {
            repository.getCharactersById(characterId).observeForever {
                _characterDetails.postValue(it)
            }
        }
    }
}