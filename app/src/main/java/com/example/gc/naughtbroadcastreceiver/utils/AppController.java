package com.example.gc.naughtbroadcastreceiver.utils;

import android.app.Application;
import android.content.BroadcastReceiver;

import com.example.gc.naughtbroadcastreceiver.receiverHelper.DynamicReceiver;

public class AppController extends Application {

    private BroadcastReceiver receiver;
    MyReceiver mR;

    @Override
    public void onCreate() {
        super.onCreate();
        mR = new MyReceiver();
        receiver = DynamicReceiver.with(mR)
                .register(this);

    }
}
