package ru.vssemikoz.rickandmortyapp

import android.app.Application
import android.util.Log
import ru.vssemikoz.rickandmortyapp.di.ApplicationComponent
import ru.vssemikoz.rickandmortyapp.di.ApplicationModule
import ru.vssemikoz.rickandmortyapp.di.DaggerApplicationComponent

class MainApplication : Application() {
    companion object {

        private lateinit var applicationComponent: ApplicationComponent
        private lateinit var instance: MainApplication

        fun getInstance(): MainApplication? {
            return instance
        }

        fun getApplicationComponent(): ApplicationComponent {
            return applicationComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(instance))
            .build()
        Log.d("onCreate MainApplication", "$applicationComponent")

    }
}
