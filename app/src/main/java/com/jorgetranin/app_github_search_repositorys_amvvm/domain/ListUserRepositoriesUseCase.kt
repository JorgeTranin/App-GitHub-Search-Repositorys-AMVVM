package com.jorgetranin.app_github_search_repositorys_amvvm.domain

import com.jorgetranin.app_github_search_repositorys_amvvm.core.UseCase
import com.jorgetranin.app_github_search_repositorys_amvvm.data.model.Repository
import com.jorgetranin.app_github_search_repositorys_amvvm.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
) : UseCase<String, List<Repository>>() {

    override suspend fun execute(param: String): Flow<List<Repository>> {
        return repository.listRepositories(param)
    }
}