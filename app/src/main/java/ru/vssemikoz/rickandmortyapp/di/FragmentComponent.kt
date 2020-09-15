package ru.vssemikoz.rickandmortyapp.di

import dagger.Subcomponent
import ru.vssemikoz.rickandmortyapp.charactersList.CharactersListFragment

@Subcomponent(modules = [
//    AdapterModule::class,
    PresenterModule::class
//    RepositoryModule.class,
//    StorageModule::class,
//    IconicStorageModule.class,
//    NavigatorModule::class
//    MapperModule.class
])
public interface FragmentComponent {
    fun inject(fragment: CharactersListFragment?)

}
