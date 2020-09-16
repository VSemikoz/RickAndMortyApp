package ru.vssemikoz.rickandmortyapp.utils.navigator

import android.app.Activity
import android.widget.ImageView
import ru.vssemikoz.rickandmortyapp.model.CharacterItem

interface Navigator {
    fun openCharacterDetailsWithTransaction(
        characterItem: CharacterItem,
        imageView: ImageView,
        fromActivity: Activity
    )
}
