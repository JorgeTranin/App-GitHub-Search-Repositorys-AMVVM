package com.jorgetranin.app_github_search_repositorys_amvvm.data

import com.jorgetranin.app_github_search_repositorys_amvvm.domain.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/repos")
    fun getAllRepositoriesByUser(@Path("user") user: String): Call<List<Repository>>

}