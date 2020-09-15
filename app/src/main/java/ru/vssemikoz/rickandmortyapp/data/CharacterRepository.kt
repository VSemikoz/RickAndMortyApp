package ru.vssemikoz.rickandmortyapp.data

import ru.vssemikoz.rickandmortyapp.model.CharacterItem

interface CharacterRepository {
    interface RequestListener {
        fun onRequestSuccess(response: List<CharacterItem>)
        fun onRequestFailure(t: Throwable?)
    }

    fun getCharacters(listener: RequestListener)
}
