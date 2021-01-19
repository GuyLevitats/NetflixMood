package com.example.netflixmood.PagesPackage;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netflixmood.BRPackage.BroadcastReceiverBattery;
import com.example.netflixmood.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btStart, btnAddMovie, btnAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initListeners();
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        unregisterReceiver(new BroadcastReceiverBattery());
//    }

    private void initUI() {
        btStart = findViewById(R.id.btStart);
        btnAddMovie = findViewById(R.id.btnAddMovie);
        btnAlarm = findViewById(R.id.btnAlarm);

        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(new BroadcastReceiverBattery(), iFilter);
    }

    private void initListeners() {
        btStart.setOnClickListener(this);
        btnAddMovie.setOnClickListener(this);
        btnAlarm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddMovie:
                Intent resultsInAdd = new Intent(getApplicationContext(), Question1Activity.class);
                resultsInAdd.putExtra("data", "Add");
                startActivity(resultsInAdd);
                break;
            case R.id.btStart:
                Intent resultsInGet = new Intent(getApplicationContext(), StartActivity.class);
                resultsInGet.putExtra("data", "Get");
                startActivity(resultsInGet);
                break;
            case R.id.btnAlarm:
                Intent resultsInAlarm = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivity(resultsInAlarm);
                break;
        }
    }

}
