package co.miniforge.corey.api_example;

import android.os.Handler;
import android.util.Log;

public class MyRunnable implements Runnable {
    boolean keepRunning = true;

    Handler handler;

    int delayAmount = 2000;

    public MyRunnable(Handler handler){
        this.handler = handler;
    }

    public void stopRunnable() {
        keepRunning = false;
    }

    @Override
    public void run() {
        Log.i("MyRunnable", "Hello, I am a custom runnable");

        if(keepRunning){
            handler.postDelayed(this, delayAmount);
        }
    }
}
