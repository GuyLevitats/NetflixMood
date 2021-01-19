package com.example.netflixmood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {


    Button mButton,btnext;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mButton=findViewById(R.id.alert2Btn);
        btnext=findViewById(R.id.btnext);
        mTextView=findViewById(R.id.aText);

        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultsIn = new Intent(getApplicationContext(), Main6Activity.class);
                startActivity(resultsIn);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder= new AlertDialog.Builder(Main5Activity.this, R.style.AlertDialogThese);

                builder.setTitle("Do you want to watch serie or a movie?");

                builder.setIcon(R.drawable.ic_action_list);

                builder.setCancelable(false);

                final String[] listItems = new String []{

                        "Serie",
                        "Movie"
                };

                builder.setSingleChoiceItems(listItems,-1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mTextView.setText(listItems[which]);
                        Toast.makeText(Main5Activity.this, "your choice is-"+listItems[which],Toast.LENGTH_SHORT).show();


                    }
                });
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                AlertDialog dialog= builder.create();
                dialog.show();

            }
        });
    }

}
