package ru.vssemikoz.rickandmortyapp.data

import retrofit2.http.GET
import ru.vssemikoz.rickandmortyapp.model.Character

interface CharacterApi {
    @GET("/character")
    fun getCharacters(): Character
}
