package ru.vssemikoz.rickandmortyapp.model

import com.google.gson.annotations.SerializedName

class CharacterApiResponse {
    @SerializedName("results")
    lateinit var newsApiResponseListCharacter: List<ResponseCharacterItem?>

    @SerializedName("info")
    lateinit var newsApiResponseInfo: ResponseInfoItem
}
