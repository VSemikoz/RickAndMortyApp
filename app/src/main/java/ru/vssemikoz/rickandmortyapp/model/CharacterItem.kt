package ru.vssemikoz.rickandmortyapp.model

import java.io.Serializable

data class CharacterItem(
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val imageUrl: String,
    val episode: List<String>,
    val created: String
) : Serializable {
    constructor(responseCharacterItem: ResponseCharacterItem) : this(
        name = responseCharacterItem.name,
        status = responseCharacterItem.status,
        species = responseCharacterItem.species,
        type = responseCharacterItem.type,
        gender = responseCharacterItem.gender,
        imageUrl = responseCharacterItem.image,
        episode = responseCharacterItem.episode.toList().map { it.asString },
        created = responseCharacterItem.created
    )
}
