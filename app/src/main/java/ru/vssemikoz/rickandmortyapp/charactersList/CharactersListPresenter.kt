package ru.vssemikoz.rickandmortyapp.charactersList

import retrofit2.Response
import ru.vssemikoz.rickandmortyapp.MainApplication
import ru.vssemikoz.rickandmortyapp.data.CharacterRepository
import ru.vssemikoz.rickandmortyapp.model.CharacterApiResponse
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
            override fun onRequestSuccess(response: Response<CharacterApiResponse>) {
                if (!response.isSuccessful) return
                characterItems = mutableListOf()
                response.body()?.newsApiResponseItemList?.forEach {
                    characterItems.add(CharacterItem(it!!))
                }
                updateNewsListUI()
            }

            override fun onRequestFailure(t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateNewsListUI() {
        if (characterItems.isEmpty()) {
            view.showEmptyView()
        } else {
            view.showList(characterItems)
        }
    }

}
