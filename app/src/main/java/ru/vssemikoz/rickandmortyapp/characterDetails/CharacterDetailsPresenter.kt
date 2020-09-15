package ru.vssemikoz.rickandmortyapp.characterDetails

import ru.vssemikoz.rickandmortyapp.MainApplication
import ru.vssemikoz.rickandmortyapp.data.CharacterRepository
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import javax.inject.Inject

class CharacterDetailsPresenter @Inject constructor() : CharacterDetailsContract.Presenter {

    private lateinit var view: CharacterDetailsContract.View
    private var characterItems: MutableList<CharacterItem> = mutableListOf()
    @Inject
    lateinit var repository: CharacterRepository
    @Inject
    lateinit var mainApplication: MainApplication

    override fun setView(view: CharacterDetailsContract.View) {
        this.view = view
    }

}
