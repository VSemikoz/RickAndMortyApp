package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vssemikoz.rickandmortyapp.AppConfig
import ru.vssemikoz.rickandmortyapp.data.CharacterApi

@Module
class NetworkModule {
    @Provides
    fun provideRetrofit(config: AppConfig): Retrofit {
        return Retrofit.Builder()
            .baseUrl(config.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideNewsApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create<CharacterApi>(CharacterApi::class.java)
    }
}
