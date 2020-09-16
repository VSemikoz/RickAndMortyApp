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
        //get info from API to get number of pages of characters
        val call: Call<CharacterApiResponse> = api.getInfo()
        call.enqueue(getInfoApiCallBack(listener))
    }

    private fun getInfoApiCallBack(listener: CharacterRepository.RequestListener): Callback<CharacterApiResponse> {
        return object : Callback<CharacterApiResponse> {
            override fun onResponse(
                call: Call<CharacterApiResponse>, response: Response<CharacterApiResponse>
            ) {
                if (!response.isSuccessful) listener.onRequestFailure(Throwable("Response info is'n success"))
                //get number of pages
                var numberOfPages = response.body()?.apiResponseInfo?.pages?.toInt()
                if (numberOfPages == null) numberOfPages = 0
                repeat(numberOfPages) {
                    //perform call for each page to get characters
                    val characterCall: Call<CharacterApiResponse> = api.getCharacters("$it")
                    characterCall.enqueue(getCharacterApiCallBack(listener))
                }
            }

            override fun onFailure(call: Call<CharacterApiResponse>, t: Throwable) {
                listener.onRequestFailure(t)
            }
        }
    }

    private fun getCharacterApiCallBack(listener: CharacterRepository.RequestListener): Callback<CharacterApiResponse> {
        return object : Callback<CharacterApiResponse> {
            override fun onResponse(
                call: Call<CharacterApiResponse>, response: Response<CharacterApiResponse>
            ) {
                if (!response.isSuccessful) listener.onRequestFailure(Throwable("Response character is'n success"))
                //for each page update data on main page
                listener.onRequestSuccess(mapper.map(response.body()))
            }

            override fun onFailure(call: Call<CharacterApiResponse>, t: Throwable) {
                listener.onRequestFailure(t)
            }
        }
    }

}
