package ru.vssemikoz.rickandmortyapp.data

import retrofit2.Response
import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse

interface CharacterRepository {
    interface RequestListener {
        fun onRequestSuccess(response: Response<CharacterApiResponse>)
        fun onRequestFailure(t: Throwable?)
    }

    fun getCharacters(listener: RequestListener)
}
