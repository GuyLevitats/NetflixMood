package com.example.netflixmood.PagesPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.netflixmood.R;

public class Question3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton2, btNext;
    private TextView mTextView;
    private String language, who, typeMovie, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        initUI();
        initListeners();
    }

    private void initUI() {
        mButton2 = findViewById(R.id.alert2Btn);
        btNext = findViewById(R.id.btNext);
        mTextView = findViewById(R.id.aText);

        who = getIntent().getStringExtra("who");
        typeMovie = getIntent().getStringExtra("typeMovie");
        data = getIntent().getStringExtra("data");
    }

    private void initListeners() {
        mButton2.setOnClickListener(this);
        btNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btNext:
                if (language != null) {
                    Intent resultsIn = new Intent(getApplicationContext(), Question4Activity.class);
                    resultsIn.putExtra("who", who);
                    resultsIn.putExtra("typeMovie", typeMovie);
                    resultsIn.putExtra("language", language);
                    resultsIn.putExtra("data", data);
                    startActivity(resultsIn);
                }
                break;
            case R.id.alert2Btn:
                AlertDialog.Builder builder = new AlertDialog.Builder(Question3Activity.this, R.style.AlertDialogThese);
                builder.setTitle("Choose language");
                builder.setIcon(R.drawable.ic_action_list);
                builder.setCancelable(false);

                final String[] listItems = new String[]{
                        "English",
                        "Hebrew"
                };

                builder.setSingleChoiceItems(listItems, -1, (dialog, which) -> {
                    mTextView.setText(listItems[which]);
                    language = listItems[which];
                    Toast.makeText(Question3Activity.this, "your choice is-" + listItems[which], Toast.LENGTH_SHORT).show();
                });

                builder.setPositiveButton("ok", (dialog, which) -> dialog.dismiss());

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }

}
