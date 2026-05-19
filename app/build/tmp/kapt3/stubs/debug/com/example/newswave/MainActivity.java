package com.example.newswave;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/newswave/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "newsAdapter", "Lcom/example/newswave/ui/NewsAdapter;", "newsApiService", "Lcom/example/newswave/data/NewsApiService;", "getNewsApiService", "()Lcom/example/newswave/data/NewsApiService;", "newsApiService$delegate", "Lkotlin/Lazy;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "loadNews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openArticle", "url", "", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout;
    private com.example.newswave.ui.NewsAdapter newsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy newsApiService$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.newswave.data.NewsApiService getNewsApiService() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadNews() {
    }
    
    private final void openArticle(java.lang.String url) {
    }
}