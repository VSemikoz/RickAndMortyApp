package ru.vssemikoz.rickandmortyapp.model

data class CharacterItem(
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val imageUrl: String,
    val episode: List<String>,
    val created: String
) {
    constructor(responseItem: CharacterResponseItem) : this(
        name = responseItem.name,
        status = responseItem.status,
        species = responseItem.species,
        type = responseItem.type,
        gender = responseItem.gender,
        imageUrl = responseItem.image,
        episode = responseItem.episode.toList().map { it.asString },
        created = responseItem.created
    )
}
