package com.jorgetranin.app_github_search_repositorys_amvvm.repositories

import com.jorgetranin.app_github_search_repositorys_amvvm.data.model.Repository
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repository>>
}