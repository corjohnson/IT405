package com.example.corey.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /* class variables and view references go here! */
    TextView displayTextView;
    Button updateButton;

    UpdateButtonClickListener updateButtonClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This method will set the layout file that your activity uses to render the UI
        //NOTE: Someone pointed out that rotating the device will re-render the UI to the default state, we will talk about this at a future point
        setContentView(R.layout.textview_button_challenge);

        displayToast();

        logStuff();

        locateViews();

        bindData();
    }

    /**
     * This method has a few different ways you can create a toast, please feel free to uncomment
     * or comment out specific lines to try them out. I will do a few in line comments above each
     * to provide some context
     *
     * https://developer.android.com/guide/topics/ui/notifiers/toasts.html
     */
    private void displayToast(){
        //This is the most standard way to make a toast, I personally use short length because Toast
        //is not good for displaying large chunks of information. Toast is intended to be 1-2 lines max
        //https://developer.android.com/reference/android/widget/Toast.html#makeText(android.content.Context, java.lang.CharSequence, int)

        Toast.makeText(getApplicationContext(), "My toast message", Toast.LENGTH_SHORT).show();

        //This way of creating a toast pulls the string message from the strings.xml resource. This is
        //beneficial to do if your app supports multiple languages, as these string files can be localized
        //https://developer.android.com/reference/android/widget/Toast.html#makeText(android.content.Context, int, int)

        //Toast.makeText(getApplicationContext(), getString(R.string.toast_text), Toast.LENGTH_LONG).show();
    }

    /**
     * Logging is a very useful way to keep track of data long term. There are 3 primary kinds of
     * log entries.
     *
     * Log.d - Debug, Log.e - Error, and Log.i - Information
     *
     * I personally steer more towards information and error. It's important to use good Java habits as well here.
     * If you just call textView.toString(), you will get a hex address. You must know how to get the
     * text from that TextView in order to really log it's info (textView.getText())
     */
    private void logStuff(){
        //Info
        Log.i("MyLogTag", "Hey! I'm in the log!");

        //Error
        /*
            In this example I'm creating a variable that will store the tag, which is a good approach.
            If you just create the tag and then save it at the top of your class as a field, you will
            not have to worry about forgetting what your other logs were tagged with for that class
        */
        String tag = "MyLogTag";
        Log.e(tag, "This is an error!");

        //Debug
        Log.d("TEST", "This is a debug log!");

        //Note: I made this so if you want to look at the android monitor, you can practice filtering for these tags
    }

    /**
     *  Often times, it's best practice to have a function or even a separate object that is entirely
     *  dedicated to making a bunch of references to your views from the layout so that you can reduce the
     *  number of findViewById calls. So, it's good to just be in this habit of separating it!
     *
     *  Another good habit is naming your fields based off of the id of the element in the xml. It's
     *  easier to pick up a project that follows that convention. AND, it's hard for anyone to know
     *  what "button3" is responsible for in a very complex view.
     */
    private void locateViews(){
        /*
            Here you can see that I must explicitly cast the view returned by findViewById.

            All android widgets extend the View class, so findViewById returns a view, but it's your
            job to know what kind of view is implemented in the xml. In this case it's a TextView
         */
        this.displayTextView = (TextView) findViewById(R.id.displayTextView);

        //Get reference to button and cast it
        this.updateButton = (Button) findViewById(R.id.updateButton);
    }

    /**
     *  Next week we'll go over other ways you can structure your code, but I tend to do something
     *  along the lines of locate views, bind data for the majority of the things that I do. Bind data
     *  in this case is just binding our on click listener to the button
     */
    private void bindData(){
        //Create our click listener
        this.updateButtonClickListener = new UpdateButtonClickListener(displayTextView, "I'm updated");

        //Assign the on click listener to the button
        this.updateButton.setOnClickListener(updateButtonClickListener);
    }
}
