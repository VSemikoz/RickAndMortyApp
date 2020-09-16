package ru.vssemikoz.rickandmortyapp.model

data class CharacterDetailsItem(
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val imageUrl: String,
    val episode: String,
    val created: String
) {
}
