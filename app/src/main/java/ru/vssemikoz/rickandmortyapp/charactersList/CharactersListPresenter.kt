package ru.vssemikoz.rickandmortyapp.charactersList

import ru.vssemikoz.rickandmortyapp.MainApplication
import ru.vssemikoz.rickandmortyapp.data.CharacterRepository
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import javax.inject.Inject

class CharactersListPresenter @Inject constructor() : CharactersListContract.Presenter {

    private lateinit var view: CharactersListContract.View
    private var characterItems: MutableList<CharacterItem> = mutableListOf()

    @Inject
    lateinit var repository: CharacterRepository

    @Inject
    lateinit var mainApplication: MainApplication

    override fun setView(view: CharactersListContract.View) {
        this.view = view
    }

    override fun getCharacters() {
        repository.getCharacters(object : CharacterRepository.RequestListener {
            override fun onRequestSuccess(response: List<CharacterItem>) {
                characterItems.addAll(response)
                updateNewsListUI()
            }

            override fun onRequestFailure(t: Throwable?) {
                updateNewsListUI()
            }
        })
    }

    private fun updateNewsListUI() {
        when (characterItems.isEmpty()) {
            true -> view.showEmptyView()
            else -> view.showList(characterItems)
        }
    }
}
