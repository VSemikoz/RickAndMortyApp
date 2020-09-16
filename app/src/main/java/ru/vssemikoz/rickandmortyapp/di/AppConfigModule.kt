package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.AppConfig
import ru.vssemikoz.rickandmortyapp.BuildConfig

@Module
class AppConfigModule {
    @Provides
    fun provideAppConfig(): AppConfig {
        return AppConfig(
            BuildConfig.MAIN_URL
        )
    }
}
