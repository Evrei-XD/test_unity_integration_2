package com.romans.appforunityintegration2;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class SumService extends Service {

    private int length = 0, sum = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    private void test (MainActivity mainActivity) {
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("Sum");
//
//        BroadcastReceiver receiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                if (intent.getAction().equals("Sum")) {
//
//                }
//            }
//        };
//        registerReceiver(receiver, intentFilter);
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        length = intent.getIntExtra("length", 0);

        for (int i = 0; i < length; i++) {
            sum += 1;
        }

        Intent in = new Intent("Sum");
        in.putExtra("sum", sum);
        sendBroadcast(in);

        return super.onStartCommand(intent, flags, startId);
    }
}
