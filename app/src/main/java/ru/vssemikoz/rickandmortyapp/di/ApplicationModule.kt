package ru.vssemikoz.rickandmortyapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.MainApplication

@Module
class ApplicationModule(private val application: MainApplication) {

    @Provides
    fun provideApplication(): MainApplication {
        return application
    }

    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }

}
