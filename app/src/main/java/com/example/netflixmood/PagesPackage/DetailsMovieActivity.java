package com.example.netflixmood.PagesPackage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netflixmood.R;
import com.example.netflixmood.UtilsPackage.FirebaseManager;

public class DetailsMovieActivity extends AppCompatActivity {

    private TextView tvDetails;
    private FirebaseManager firebaseManager;
    private String type, language, who, typeMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        initUI();
        readFireStore();
    }

    private void initUI() {
        tvDetails = findViewById(R.id.tvDetails);

        type = getIntent().getStringExtra("type");
        language = getIntent().getStringExtra("language");
        who = getIntent().getStringExtra("who");
        typeMovie = getIntent().getStringExtra("typeMovie");

        firebaseManager = new FirebaseManager();
        firebaseManager.initFirestore();
    }

    private void readFireStore() {
        firebaseManager.getDocumentDataFirestore(type, language, who, typeMovie, tvDetails);
    }

}
