package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.charactersList.CharactersListContract
import ru.vssemikoz.rickandmortyapp.charactersList.CharactersListPresenter

@Module
class PresenterModule {
    @Provides
    fun provideProductListPresenter(presenter: CharactersListPresenter): CharactersListContract.Presenter {
        return presenter
    }
}
