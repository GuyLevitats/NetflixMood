package com.example.netflixmood.AdaptersPackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.netflixmood.R;

public class ViewHolderMovies extends RecyclerView.ViewHolder {

    public TextView tvName;
    public LinearLayout linearLayout1;

    public ViewHolderMovies(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tvName);
        linearLayout1 = itemView.findViewById(R.id.linearLayout1);
    }

}
