package com.example.gc.naughtbroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gc.naughtbroadcastreceiver.interfaces.GlobalReceiverCallBack;
import com.example.gc.naughtbroadcastreceiver.utils.Session;

public class MainActivity extends AppCompatActivity implements GlobalReceiverCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Session.setmGlobalReceiverCallback(this);

    }

    @Override
    public void onCallBackReceived(Context context, Intent intent) {

        Toast.makeText(context, "" + intent.getAction(), Toast.LENGTH_LONG).show();
    }
}
