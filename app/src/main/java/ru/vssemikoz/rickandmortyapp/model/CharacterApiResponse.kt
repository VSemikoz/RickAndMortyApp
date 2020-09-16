package ru.vssemikoz.rickandmortyapp.model

import com.google.gson.annotations.SerializedName

class CharacterApiResponse {
    @SerializedName("results")
    lateinit var apiResponseListCharacter: List<ResponseCharacterItem?>

    @SerializedName("info")
    lateinit var apiResponseInfo: ResponseInfoItem
}
