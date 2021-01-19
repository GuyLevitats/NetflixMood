package com.example.netflixmood.BRPackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiverBattery extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        assert action != null;
        switch (action) {
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "The phone is charging", Toast.LENGTH_LONG).show();
                break;
        }
    }

}
