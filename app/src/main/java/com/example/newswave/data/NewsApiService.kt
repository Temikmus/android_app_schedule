package com.example.newswave.data

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("articles/")
    suspend fun getLatestArticles(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int = 0
    ): NewsResponse
}
