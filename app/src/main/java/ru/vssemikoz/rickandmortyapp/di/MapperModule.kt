package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.utils.mappers.CharacterMapper
import ru.vssemikoz.rickandmortyapp.utils.mappers.CharacterResponseMapper

@Module
class MapperModule {
    @Provides
    fun provideCharacterMapper(mapper: CharacterResponseMapper): CharacterMapper {
        return mapper
    }
}
