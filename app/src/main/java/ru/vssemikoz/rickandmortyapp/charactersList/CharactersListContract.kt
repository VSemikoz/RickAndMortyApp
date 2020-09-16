package ru.vssemikoz.rickandmortyapp.charactersList

import ru.vssemikoz.rickandmortyapp.model.CharacterItem

interface CharactersListContract {
    interface Presenter {
        fun setView(view: View)

        fun getCharacters()

    }

    interface View {
        fun showEmptyView()

        fun showList(items: MutableList<CharacterItem>)

    }
}
