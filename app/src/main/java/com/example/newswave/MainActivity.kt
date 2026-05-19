package com.example.newswave

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newswave.data.NewsApiService
import com.example.newswave.ui.NewsAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var newsAdapter: NewsAdapter

    private val newsApiService: NewsApiService by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .baseUrl("https://api.spaceflightnewsapi.net/v4/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(NewsApiService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsAdapter = NewsAdapter { url ->
            openArticle(url)
        }

        findViewById<RecyclerView>(R.id.newsRecyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            loadNews()
        }

        loadNews()
    }

    private fun loadNews() {
        swipeRefreshLayout.isRefreshing = true

        lifecycleScope.launch {
            runCatching {
                newsApiService.getLatestArticles(limit = 30)
            }.onSuccess { response ->
                newsAdapter.submitArticles(response.results)
            }.onFailure {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.news_load_error),
                    Toast.LENGTH_SHORT
                ).show()
            }

            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun openArticle(url: String?) {
        if (url.isNullOrBlank()) {
            Toast.makeText(this, getString(R.string.article_link_missing), Toast.LENGTH_SHORT).show()
            return
        }

        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}
