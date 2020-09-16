package ru.vssemikoz.rickandmortyapp.utils.mappers

import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse
import ru.vssemikoz.rickandmortyapp.model.CharacterDetailsItem
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import ru.vssemikoz.rickandmortyapp.utils.typeConverters.DateTypeConverter
import javax.inject.Inject

class CharacterResponseMapper @Inject constructor() : CharacterMapper {
    override fun map(response: CharacterApiResponse?): List<CharacterItem> {
        if (response == null) return listOf()
        val result = arrayListOf<CharacterItem>()
        response.newsApiResponseListCharacter.forEach { if (it != null) result.add(CharacterItem(it)) }
        return result
    }

    override fun map(characterItem: CharacterItem): CharacterDetailsItem {
        val fromFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        val toFormat = "dd MMM yyyy HH:mm:ss"
        return with(characterItem) {
            CharacterDetailsItem(
                name = "Name: ${if (characterItem.name == "") "No name" else characterItem.name}",
                status = "Status: ${if (characterItem.status == "") "No status" else characterItem.status}",
                species = "Species: ${if (characterItem.species == "") "No species" else characterItem.species}",
                type = "Type: ${if (characterItem.type == "") "No type" else characterItem.status}",
                gender = "Gender: ${if (characterItem.gender == "") "No gender" else characterItem.gender}",
                imageUrl = imageUrl,
                episode = "Episodes: ${if (characterItem.episode.isEmpty()) "No episodes"
                else characterItem.getEpisodesNumbers()}",
                created = "Created: ${if (characterItem.created == "") "Date unavailable"
                else characterItem.formatDate(fromFormat, toFormat)}"
            )
        }
    }

    private fun CharacterItem.getEpisodesNumbers(): String {
        return episode.joinToString(separator = ", ") { it.substringAfterLast("/") }
    }

    private fun CharacterItem.formatDate(fromFormat: String, toFormat: String): String {
        val date = DateTypeConverter.toDate(this.created, fromFormat) ?: return created
        return DateTypeConverter.toString(date, toFormat)
    }
}
