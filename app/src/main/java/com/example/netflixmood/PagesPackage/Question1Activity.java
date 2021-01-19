package com.example.netflixmood.PagesPackage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netflixmood.R;

public class Question1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton, btNext;
    private TextView mTextView;
    private String typeMovie, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initUI();
        initListeners();
    }

    private void initUI() {
        mButton = findViewById(R.id.alert2Btn);
        btNext = findViewById(R.id.btNext);
        mTextView = findViewById(R.id.aText);

        data = getIntent().getStringExtra("data");
    }

    private void initListeners() {
        mButton.setOnClickListener(this);
        btNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btNext:
                if (typeMovie != null) {
                    Intent resultsIn = new Intent(getApplicationContext(), Question2Activity.class);
                    resultsIn.putExtra("typeMovie", typeMovie);
                    resultsIn.putExtra("data", data);
                    startActivity(resultsIn);
                }
                break;
            case R.id.alert2Btn:
                AlertDialog.Builder builder = new AlertDialog.Builder(Question1Activity.this, R.style.AlertDialogThese);
                builder.setTitle("What type of movie/serie you want to watch?");
                builder.setIcon(R.drawable.ic_action_list);
                builder.setCancelable(false);

                final String[] listItems = new String[]{
                        "Comedy",
                        "Action",
                        "Drama"
                };

                builder.setSingleChoiceItems(listItems, -1, (dialog, which) -> {
                    mTextView.setText(listItems[which]);
                    typeMovie = listItems[which];
                    Toast.makeText(Question1Activity.this, "your choice is-" + listItems[which], Toast.LENGTH_SHORT).show();
                });

                builder.setPositiveButton("ok", (dialog, which) -> dialog.dismiss());

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }

}
