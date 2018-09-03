package com.example.gc.naughtbroadcastreceiver.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.broadcasts.annotations.BroadcastReceiverActions;

@BroadcastReceiverActions({"android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF",
        "android.intent.action.DREAMING_STARTED", "android.intent.action.DREAMING_STOPPED",
        "android.intent.action.ACTION_POWER_DISCONNECTED", "android.intent.action.ACTION_POWER_CONNECTED",
        "android.net.conn.CONNECTIVITY_CHANGE"})
public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Session.getGlobalReceiverCallBack(context, intent);

        //Log.e("dfd", "" + intent.getAction());
    }
}