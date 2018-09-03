package com.example.gc.naughtbroadcastreceiver.interfaces;

import android.content.Context;
import android.content.Intent;

public interface GlobalReceiverCallBack {

    void onCallBackReceived(Context context, Intent intent);

}
