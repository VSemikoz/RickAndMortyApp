package ru.vssemikoz.rickandmortyapp.charactersList

import ru.vssemikoz.rickandmortyapp.MainApplication
import javax.inject.Inject

class CharactersListPresenter @Inject constructor() : CharactersListContract.Presenter {
    private lateinit var view: CharactersListContract.View

    @Inject
    lateinit var mainApplication: MainApplication

    override fun setView(view: CharactersListContract.View) {
        this.view = view
    }

}
