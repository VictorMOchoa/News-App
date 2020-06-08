package com.eatanapple.newsapp;

import android.content.Context;

import com.eatanapple.newsapp.dto.Article;

import java.util.List;

import androidx.loader.content.AsyncTaskLoader;

public class NewsArticleLoader extends AsyncTaskLoader<List<Article>> {
    private String url;

    public NewsArticleLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        if (url == null) {
            return null;
        }

        return QueryUtils.fetchArticles(url);
    }
}
