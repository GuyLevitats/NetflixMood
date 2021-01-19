package com.example.netflixmood.AdaptersPackage;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.netflixmood.ModelsPackage.MovieModel;
import com.example.netflixmood.R;

import java.util.List;

public class AdapterMovies extends RecyclerView.Adapter<ViewHolderMovies> {

    private List<MovieModel> totalModelList;
    private final LayoutInflater mInflater;

    public AdapterMovies(List<MovieModel> totalModelList, Context context) {
        this.totalModelList = totalModelList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderMovies onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_movies, parent, false);
        return new ViewHolderMovies(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderMovies holder, final int position) {
        final MovieModel movieModel = totalModelList.get(position);
        holder.tvName.setText(movieModel.getName());
        holder.linearLayout1.setOnClickListener(v -> {
            Uri uri = Uri.parse(movieModel.getUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            mInflater.getContext().startActivity(intent);
        });
    }

    public void setMovies(List<MovieModel> totalModelList) {
        this.totalModelList = totalModelList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return totalModelList.size();
    }

}
