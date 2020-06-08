package com.eatanapple.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eatanapple.newsapp.dto.Article;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleAdapter.NewsArticleViewHolder> {

    public List<Article> articles;
    private Context context;

    public NewsArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    public class NewsArticleViewHolder extends RecyclerView.ViewHolder  {
        TextView articleTitleTextView;
        TextView categoryTextView;
        TextView dateTextView;
        ConstraintLayout itemLayout;
        public NewsArticleViewHolder(View view) {
            super(view);
            articleTitleTextView = view.findViewById(R.id.article_title_tv);
            categoryTextView = view.findViewById(R.id.category_tv);
            dateTextView = view.findViewById(R.id.date_tv);
            itemLayout = view.findViewById(R.id.tile_layout);
        }
    }


    @Override
    public NewsArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.article_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new NewsArticleViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NewsArticleViewHolder holder, final int position) {
        holder.articleTitleTextView.setText(articles.get(position).getWebTitle());
        holder.categoryTextView.setText(articles.get(position).getSectionName());
        holder.dateTextView.setText(articles.get(position).getWebPublicationDate());
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri articleURI = Uri.parse(articles.get(position).getWebUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, articleURI);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }
}
