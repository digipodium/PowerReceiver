package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "power connected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "power disconnected", Toast.LENGTH_SHORT).show();
                break;
            case MainActivity.OUR_BROADCAST:
                Toast.makeText(context, "custom broadcast received", Toast.LENGTH_SHORT).show();
        }
    }
}