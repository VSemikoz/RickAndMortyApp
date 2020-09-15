package ru.vssemikoz.rickandmortyapp.utils.mappers

import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import javax.inject.Inject

class CharacterResponseMapper @Inject constructor() : CharacterMapper {
    override fun map(response: CharacterApiResponse): List<CharacterItem> {
        val result = arrayListOf<CharacterItem>()
        response.newsApiResponseItemList?.forEach { if (it != null) result.add(CharacterItem(it)) }
        return result
    }
}
