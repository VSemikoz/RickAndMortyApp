package ru.vssemikoz.rickandmortyapp.characterDetails

import javax.inject.Inject

class CharacterDetailsPresenter @Inject constructor() : CharacterDetailsContract.Presenter {

    private lateinit var view: CharacterDetailsContract.View

    override fun setView(view: CharacterDetailsContract.View) {
        this.view = view
    }
}
