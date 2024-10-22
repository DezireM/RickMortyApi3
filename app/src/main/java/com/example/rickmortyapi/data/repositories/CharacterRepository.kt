package com.example.rickmortyapi.data.repositories

import androidx.lifecycle.LiveData
import com.example.rickmortyapi.data.base.BaseRepository
import com.example.rickmortyapi.data.network.api.CharacterApiService
import com.example.rickmortyapi.data.network.model.Character
import com.example.rickmortyapi.utils.Resource

class CharacterRepository(
    private val apiService: CharacterApiService
) : BaseRepository() {

    fun getAllCharacters(): LiveData<Resource<List<Character>>> = doRequest {
        apiService.getAllCharacters().characters
    }

    fun getCharactersById(id: Int): LiveData<Resource<Character>> = doRequest {
        apiService.getCharacterById(id)
    }
}