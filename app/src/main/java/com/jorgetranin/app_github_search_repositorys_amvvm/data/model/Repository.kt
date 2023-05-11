package com.jorgetranin.app_github_search_repositorys_amvvm.data.model

import com.google.gson.annotations.SerializedName

data class Repository(
    val id: Long,
    val name: String,
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stargazersCount: Long,
    val language: String,
    @SerializedName("html_url")
    val htmlURL: String,
    val description: String
)

