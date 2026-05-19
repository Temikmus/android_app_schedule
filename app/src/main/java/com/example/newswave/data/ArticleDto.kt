package com.example.newswave.data

import com.squareup.moshi.Json

data class ArticleDto(
    val id: Int,
    val title: String?,
    val url: String?,
    @Json(name = "image_url")
    val imageUrl: String?,
    @Json(name = "news_site")
    val newsSite: String?,
    val summary: String?,
    @Json(name = "published_at")
    val publishedAt: String?
)
