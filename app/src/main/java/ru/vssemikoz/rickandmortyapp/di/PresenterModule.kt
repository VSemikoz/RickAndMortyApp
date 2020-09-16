package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.characterDetails.CharacterDetailsContract
import ru.vssemikoz.rickandmortyapp.characterDetails.CharacterDetailsPresenter
import ru.vssemikoz.rickandmortyapp.charactersList.CharactersListContract
import ru.vssemikoz.rickandmortyapp.charactersList.CharactersListPresenter

@Module
class PresenterModule {
    @Provides
    fun provideCharacterListPresenter(presenter: CharactersListPresenter): CharactersListContract.Presenter {
        return presenter
    }

    @Provides
    fun provideCharacterDetailsPresenter(presenter: CharacterDetailsPresenter): CharacterDetailsContract.Presenter {
        return presenter
    }
}
