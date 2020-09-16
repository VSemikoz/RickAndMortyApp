package ru.vssemikoz.rickandmortyapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse


interface CharacterApi {
    @GET("character/")
    fun getCharacters(@Query("page") pageNumber: String): Call<CharacterApiResponse>
    @GET("character/")
    fun getInfo(): Call<CharacterApiResponse>
}
