package com.example.newswave.data

data class NewsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ArticleDto>
)
