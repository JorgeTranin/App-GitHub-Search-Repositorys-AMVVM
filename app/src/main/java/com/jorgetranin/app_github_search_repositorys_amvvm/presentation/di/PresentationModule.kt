package com.jorgetranin.app_github_search_repositorys_amvvm.presentation.di

import com.jorgetranin.app_github_search_repositorys_amvvm.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): Module {
        return module {
            viewModel { MainViewModel(get()) }
        }
    }
}