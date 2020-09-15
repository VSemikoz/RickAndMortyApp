package ru.vssemikoz.rickandmortyapp

import android.app.Application
import ru.vssemikoz.rickandmortyapp.di.ApplicationComponent
import ru.vssemikoz.rickandmortyapp.di.ApplicationModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
//        applicationComponent = DaggerApplicationComponent.builder()
//            .applicationModule(ApplicationModule(instance!!))
//            .build()
    }

    companion object {
        private var applicationComponent: ApplicationComponent? = null
        var instance: MainApplication? = null
            private set

        fun getApplicationComponent(): ApplicationComponent? {
            return applicationComponent
        }
    }
}
