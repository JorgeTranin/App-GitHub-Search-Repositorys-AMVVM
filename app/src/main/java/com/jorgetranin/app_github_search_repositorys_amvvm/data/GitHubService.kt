package com.jorgetranin.app_github_search_repositorys_amvvm.data

import com.jorgetranin.app_github_search_repositorys_amvvm.data.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String): List<Repository>

}