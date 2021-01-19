package com.example.netflixmood.PagesPackage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netflixmood.R;
import com.example.netflixmood.UtilsPackage.FirebaseManager;

public class AllMoviesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        initUI();
        getDataFirestore();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);

        firebaseManager = new FirebaseManager();
        firebaseManager.initFirestore();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFirestore() {
        firebaseManager.getAllDataFirestore(this, recyclerView);
    }

}
