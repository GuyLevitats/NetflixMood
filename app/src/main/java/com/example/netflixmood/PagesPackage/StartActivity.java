package com.example.netflixmood.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.netflixmood.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btMy, btAll;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initUI();
        initListeners();
    }

    private void initUI() {
        btMy = findViewById(R.id.btMy);
        btAll = findViewById(R.id.btAll);

        data = getIntent().getStringExtra("data");
    }

    private void initListeners() {
        btMy.setOnClickListener(this);
        btAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btMy:
                Intent intent1 = new Intent(getApplicationContext(), Question1Activity.class);
                intent1.putExtra("data", data);
                startActivity(intent1);
                break;
            case R.id.btAll:
                Intent intent2 = new Intent(getApplicationContext(), AllMoviesActivity.class);
                startActivity(intent2);
                break;
        }
    }

}
