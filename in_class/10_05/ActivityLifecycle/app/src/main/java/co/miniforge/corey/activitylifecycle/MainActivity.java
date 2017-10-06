package co.miniforge.corey.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String logTag = "ActivityLifecycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(logTag, "onCreate Called");

        /*
            In onCreate, you would want to set up any parts of your
            activity that you'd want ready before the user sees the
            page. So you could call findViewById for the different
            elements so that you have references to them already
         */
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(logTag, "onStart Called");

        /*
            onStart is a good place to write code that should run just as the
            Activity becomes visible. As an example, if you're making an app
            that has an embedded camera, you'd initialize it here
         */
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(logTag, "onResume Called");

        /*
            onResume is called when an activity is considered "in the foreground".
            What this means is that if you have a little share button that brings up
            a drawer from the bottom, or a modal that appears over the top of your
            activity, when those are dismissed, onResume is called again
         */
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(logTag, "onPause Called");

        /*
            onPause is called whenever your activity loses it's foreground state

            So if you have a nav drawer from the bottom appear when you press a button,
            then it will get the foreground state, and your activity's onPause will be called
         */
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(logTag, "onStop Called");

        /*
            onStop is called when the activity is dismissed. So when you hit the home button, onStop
            is called because your activity is no longer visible
         */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(logTag, "onDestroy Called");

        /*
            onDestroy is called when your activity is garbage collected. Do any last minute clean up
            here, but if you have caching or anything that needs to happen, it should probably be
            done in onStop
         */
    }
}
