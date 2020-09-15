package ru.vssemikoz.rickandmortyapp.data

import retrofit2.Call
import retrofit2.http.GET
import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse


interface CharacterApi {
    @GET("character/")
    fun getCharacters(): Call<CharacterApiResponse>
}
