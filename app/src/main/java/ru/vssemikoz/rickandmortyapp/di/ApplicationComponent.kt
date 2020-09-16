package ru.vssemikoz.rickandmortyapp.di

import dagger.Component
import ru.vssemikoz.rickandmortyapp.MainApplication

@Component(
    modules = [ApplicationModule::class,
        NetworkModule::class,
        AppConfigModule::class]
)
interface ApplicationComponent {
    fun inject(mainApplication: MainApplication)

    fun fragmentComponent(): FragmentComponent
}
