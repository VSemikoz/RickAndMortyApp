package ru.vssemikoz.rickandmortyapp.di

import dagger.Subcomponent
import ru.vssemikoz.rickandmortyapp.characterDetails.CharacterDetailsFragment
import ru.vssemikoz.rickandmortyapp.charactersList.CharactersListFragment

@Subcomponent(
    modules = [
        AdapterModule::class,
        PresenterModule::class,
        RepositoryModule::class,
        NavigatorModule::class,
        MapperModule::class
    ]
)
interface FragmentComponent {
    fun inject(fragment: CharactersListFragment?)
    fun inject(fragment: CharacterDetailsFragment?)
}
