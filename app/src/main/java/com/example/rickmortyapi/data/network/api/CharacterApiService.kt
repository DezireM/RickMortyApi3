package com.example.rickmortyapi.data.network.api

import com.example.rickmortyapi.data.network.model.BaseResponse
import com.example.rickmortyapi.data.network.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {
    @GET("character")
    suspend fun getAllCharacters(): BaseResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Character
}