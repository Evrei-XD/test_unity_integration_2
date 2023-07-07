package com.romans.appforunityintegration2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class DataTransferToService extends Service {

    private int length = 0, sum = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

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
