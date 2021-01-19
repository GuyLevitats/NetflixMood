package com.example.netflixmood.PagesPackage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netflixmood.R;
import com.example.netflixmood.UtilsPackage.FirebaseManager;

public class AddMovieActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText urlMovie, nameMovie;
    private Button btnAddMovie;
    private String type, language, who, typeMovie;
    private FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        initUI();
        initListeners();
    }

    private void initUI() {
        urlMovie = findViewById(R.id.urlMovie);
        nameMovie = findViewById(R.id.nameMovie);
        btnAddMovie = findViewById(R.id.btnAddMovie);

        type = getIntent().getStringExtra("type");
        language = getIntent().getStringExtra("language");
        who = getIntent().getStringExtra("who");
        typeMovie = getIntent().getStringExtra("typeMovie");

        firebaseManager = new FirebaseManager();
        firebaseManager.initFirestore();
    }

    private void initListeners() {
        btnAddMovie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddMovie:
                firebaseManager.addDocumentDataFirestore(type, language, who, typeMovie,
                        urlMovie.getText().toString(), nameMovie.getText().toString(), this);
                break;
        }
    }

}
