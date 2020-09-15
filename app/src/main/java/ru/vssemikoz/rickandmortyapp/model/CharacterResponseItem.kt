package ru.vssemikoz.rickandmortyapp.model

import com.google.gson.JsonArray

data class CharacterResponseItem(
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val episode: JsonArray,
    val created: String
)
