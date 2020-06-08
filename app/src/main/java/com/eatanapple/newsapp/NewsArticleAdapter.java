package com.eatanapple.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eatanapple.newsapp.dto.Article;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleAdapter.NewsArticleViewHolder> {

    public List<Article> articles;
    private Context context;

    public NewsArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    public class NewsArticleViewHolder extends RecyclerView.ViewHolder  {
//        TextView attractionNameTextView;
//        TextView addressTextView;
//        TextView hoursTextView;
//        ImageView locationImageView;
        public NewsArticleViewHolder(View view) {
            super(view);
//            attractionNameTextView = view.findViewById(R.id.attraction_name_tv);
//            addressTextView = view.findViewById(R.id.address_tv);
//            hoursTextView = view.findViewById(R.id.hours_tv);
//            locationImageView = view.findViewById(R.id.event_iv);
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
    public void onBindViewHolder(NewsArticleViewHolder holder, int position) {
//        holder.attractionNameTextView.setText(attractions.get(position).getName());
//        holder.addressTextView.setText(attractions.get(position).getLocation());
//        holder.hoursTextView.setText(attractions.get(position).getHours());
//        Drawable drawable = context.getResources().getDrawable(attractions.get(position).getPictureResourceId());
//        holder.locationImageView.setImageDrawable(drawable);
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }
}
