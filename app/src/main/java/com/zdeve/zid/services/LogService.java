package com.zdeve.zid.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class LogService extends Service {
    public LogService() {
    }
    Thread workedThread;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        workedThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                    if (workedThread.isInterrupted()){
                        break;
                    }
                    System.out.println("Working..");
                }
            }
        });
        workedThread.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        workedThread.interrupt();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
