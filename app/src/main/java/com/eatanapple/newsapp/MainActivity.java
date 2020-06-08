package com.eatanapple.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eatanapple.newsapp.dto.Article;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Article>>{
    private static final String API_URL = "https://content.guardianapis.com/search?api-key=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loader<List<Article>> manager = LoaderManager.getInstance(this).initLoader(1, null, this);
    }

    @NonNull
    @Override
    public Loader<List<Article>> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsArticleLoader(this, API_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Article>> loader, List<Article> data) {
        RecyclerView recyclerView = findViewById(R.id.articles_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        NewsArticleAdapter adapter = new NewsArticleAdapter(getApplicationContext(), data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Article>> loader) {

    }
}