package com.jorgetranin.app_github_search_repositorys_amvvm.domain

import com.google.gson.annotations.SerializedName

data class Repository (
    val name: String,
    @SerializedName("html_url")
    val htmlUrl: String
)