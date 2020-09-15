package ru.vssemikoz.rickandmortyapp.model

import com.google.gson.annotations.SerializedName

class CharacterApiResponse {
    @SerializedName("results")
    val newsApiResponseItemList: List<CharacterResponseItem?>? = null
}
