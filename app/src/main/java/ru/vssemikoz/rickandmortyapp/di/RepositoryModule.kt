package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.data.CharacterRepository
import ru.vssemikoz.rickandmortyapp.data.RemoteCharacterRepository

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(repository: RemoteCharacterRepository): CharacterRepository {
        return repository
    }
}
