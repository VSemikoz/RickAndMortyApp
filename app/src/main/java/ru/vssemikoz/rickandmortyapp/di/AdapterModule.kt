package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.adapters.BaseAdapter
import ru.vssemikoz.rickandmortyapp.adapters.CharacterAdapter
import ru.vssemikoz.rickandmortyapp.model.CharacterItem

@Module
class AdapterModule {
    @Provides
    fun provideAdapter(adapter: CharacterAdapter): BaseAdapter<CharacterItem> {
        return adapter
    }
}
