package com.example.powerreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    public static final String OUR_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_SECRET_BROADCAST";
    private CustomReceiver receiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new CustomReceiver();
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(OUR_BROADCAST);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver, filter);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(OUR_BROADCAST));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
    
}