package com.jorgetranin.app_github_search_repositorys_amvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgetranin.app_github_search_repositorys_amvvm.data.model.Repository
import com.jorgetranin.app_github_search_repositorys_amvvm.domain.ListUserRepositoriesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class MainViewModel(
    private val listUserRepositoriesUseCase: ListUserRepositoriesUseCase
) : ViewModel() {

    private val _repos = MutableLiveData<State>()
    val repos: LiveData<State> = _repos

    fun getRepoList(user: String) {
        viewModelScope.launch {
            listUserRepositoriesUseCase(user)
                .onStart {
                    _repos.postValue(State.Loading)
                }
                .catch {
                    _repos.postValue(State.Error(it))
                }
                .collect {
                    _repos.postValue(State.Success(it))
                }
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val list: List<Repository>) : State()
        data class Error(val error: Throwable) : State()
    }

}