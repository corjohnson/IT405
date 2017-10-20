package co.miniforge.corey.api_example;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Handler handler = new Handler();
//        MyRunnable runnable = new MyRunnable(handler);
//        handler.post(runnable);

        final MyAsyncHelper helper = new MyAsyncHelper();
        HandlerThread thread = new HandlerThread("Test");
        thread.start();
        Handler threadHandler = new Handler(thread.getLooper());

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                //Log.i("HELLO", helper.getData("https://wt-009118fe5913a9a73c82768e11abf7ea-0.run.webtask.io/greeter"));
                String s = helper.getData("http://www.recipepuppy.com/api/?q=apple");

                try {
                    JSONObject json = new JSONObject(s);

                    Log.i("TEST", json.getString("title"));
                } catch (Exception e){

                }

                Log.i("TEST", s);

                Toast.makeText(getApplicationContext(),
                        s, Toast.LENGTH_SHORT).show();
            }
        };

        threadHandler.post(runnable1);
    }
}
