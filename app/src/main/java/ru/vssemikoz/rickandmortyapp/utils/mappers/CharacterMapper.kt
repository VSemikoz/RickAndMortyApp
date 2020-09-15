package ru.vssemikoz.rickandmortyapp.utils.mappers

import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse
import ru.vssemikoz.rickandmortyapp.model.CharacterItem

interface CharacterMapper {
    fun map(response: CharacterApiResponse): List<CharacterItem>
}
