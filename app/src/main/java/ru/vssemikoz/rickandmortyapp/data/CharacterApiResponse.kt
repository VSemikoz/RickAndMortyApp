package ru.vssemikoz.rickandmortyapp.data

import com.google.gson.annotations.SerializedName
import ru.vssemikoz.rickandmortyapp.model.Character

class CharacterApiResponse {
    @SerializedName("results")
    val newsApiResponseItemList: List<Character?>? = null
}
