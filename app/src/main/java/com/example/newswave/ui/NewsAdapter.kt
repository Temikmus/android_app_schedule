package com.example.newswave.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newswave.R
import com.example.newswave.data.ArticleDto

class NewsAdapter(
    private val onArticleClick: (String?) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val articles = mutableListOf<ArticleDto>()

    fun submitArticles(newArticles: List<ArticleDto>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.articleImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.articleTitleTextView)
        private val sourceTextView: TextView = itemView.findViewById(R.id.articleSourceTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.articleDateTextView)
        private val summaryTextView: TextView = itemView.findViewById(R.id.articleSummaryTextView)

        fun bind(article: ArticleDto) {
            titleTextView.text = article.title.orEmpty()
            sourceTextView.text = article.newsSite.orEmpty()
            dateTextView.text = article.publishedAt.toDisplayDate()
            summaryTextView.text = article.summary.orEmpty()

            imageView.load(article.imageUrl) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                error(R.drawable.ic_launcher_background)
            }

            itemView.setOnClickListener {
                onArticleClick(article.url)
            }
        }
    }

    private fun String?.toDisplayDate(): String {
        if (isNullOrBlank()) return ""
        return replace("T", " ")
            .substringBefore(".")
            .removeSuffix("Z")
    }
}
