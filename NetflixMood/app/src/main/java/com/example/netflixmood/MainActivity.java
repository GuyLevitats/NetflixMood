package com.example.netflixmood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvheadline;
    ImageView ivsta;
    Button btstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvheadline= (TextView) findViewById(R.id.tvheadline);
        ivsta =  (ImageView) findViewById(R.id.ivsta);
        btstart=  (Button) findViewById(R.id.btstart);
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultsIn = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(resultsIn);
            }
        });
    }
}

