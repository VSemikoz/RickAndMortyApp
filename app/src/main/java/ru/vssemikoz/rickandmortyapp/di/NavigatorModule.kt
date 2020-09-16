package ru.vssemikoz.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.rickandmortyapp.utils.navigator.Navigator
import ru.vssemikoz.rickandmortyapp.utils.navigator.NavigatorImpl

@Module
class NavigatorModule {
    @Provides
    fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator {
        return navigatorImpl
    }
}
