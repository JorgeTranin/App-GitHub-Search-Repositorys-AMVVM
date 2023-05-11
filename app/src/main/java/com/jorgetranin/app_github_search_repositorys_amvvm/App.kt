package com.jorgetranin.app_github_search_repositorys_amvvm

import android.app.Application
import com.jorgetranin.app_github_search_repositorys_amvvm.data.di.DataModule
import com.jorgetranin.app_github_search_repositorys_amvvm.domain.di.DomainModule
import com.jorgetranin.app_github_search_repositorys_amvvm.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}