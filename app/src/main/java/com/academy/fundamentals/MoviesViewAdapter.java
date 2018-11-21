package com.academy.fundamentals;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MoviesViewAdapter extends RecyclerView.Adapter<MoviesViewAdapter.ViewHolder> {

    private final ArrayList<MovieModel> movies;
    private LayoutInflater mLayoutInflater;
    private OnMovieClickListener movieClickListener;

    public MoviesViewAdapter(ArrayList<MovieModel> items, Context context, OnMovieClickListener onMovieClickListener) {
        this.movies = items;
        this.mLayoutInflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.movieClickListener = onMovieClickListener;

        // Set instance of the OnMovieClickListener interface in your RecyclerView.Adapter
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ImageView ivImage;
        final TextView tvTitle;
        final TextView tvOverview;

        // ViewHolder Constructor

        private ViewHolder(View view) {
            super(view);
            ivImage = view.findViewById(R.id.item_movie_iv);
            tvTitle = view.findViewById(R.id.item_movie_tv_title);
            tvOverview = view.findViewById(R.id.item_movie_tv_overview);
            view.setOnClickListener(this);
        }

        private void bind(MovieModel movieModel) {
            ivImage.setImageResource(movieModel.getImageResId());
            tvTitle.setText(movieModel.getMovieName());
            tvOverview.setText(movieModel.getOverview());
        }

        @Override
        public void onClick(View view) {
            if (movieClickListener == null) return;
            // call the relevant callback of you interface.
            // get adapter position will give us the position of the item clicked.
            movieClickListener.onMovieClicked(getAdapterPosition());
        }
    }
}
