package ru.vssemikoz.rickandmortyapp.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse
import ru.vssemikoz.rickandmortyapp.utils.mappers.CharacterMapper
import javax.inject.Inject


class RemoteCharacterRepository @Inject constructor() : CharacterRepository {
    @Inject
    lateinit var api: CharacterApi
    @Inject
    lateinit var mapper: CharacterMapper

    override fun getCharacters(listener: CharacterRepository.RequestListener) {
        val call: Call<CharacterApiResponse> = api.getCharacters()
        call.enqueue(getNewsApiCallBack(listener))
    }

    private fun getNewsApiCallBack(listener: CharacterRepository.RequestListener): Callback<CharacterApiResponse> {
        return object : Callback<CharacterApiResponse> {
            override fun onResponse(
                call: Call<CharacterApiResponse>,
                response: Response<CharacterApiResponse>
            ) {
                listener.onRequestSuccess(response)

            }

            override fun onFailure(
                call: Call<CharacterApiResponse>,
                t: Throwable
            ) {
                listener.onRequestFailure(t)

            }
        }
    }

}
