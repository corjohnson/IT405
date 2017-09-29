package com.example.corey.helloworld;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Corey on 9/29/2017.
 */

public class UpdateButtonClickListener implements View.OnClickListener {
    /* Just like in our MainActivity, our fields go here */
    TextView displayTextView;
    String messageToDisplay;

    //boolean isActive = false;

    /**
     * This is our constructor for the listener, it will take in a TextView object and a string, so
     * that we have that readily available for when we need to update the TextView.
     * @param displayTextView - A reference to a TextView from the Activity
     * @param messageToDisplay - The message we want to populate the TextView with
     */
    public UpdateButtonClickListener(TextView displayTextView, String messageToDisplay){
        this.displayTextView = displayTextView;
        this.messageToDisplay = messageToDisplay;
    }

    /**
     * All View objects can have click listeners, it's up to you as the developer to determine what
     * information you need to do something in the onClick method. Chances are you'll want to put
     * that required info in the constructor.
     *
     * @param view - This is the view that was clicked
     */
    @Override
    public void onClick(View view) {
        //Set the text of the TextView
        displayTextView.setText(messageToDisplay);

        /*
            I can also do other things with my TextView here. If I have a boolean that is updated when
            onClick is called, I can toggle between two states of my text.

            Example: */

        /* if(isActive){
            displayTextView.setText("Click me!");
            isActive = false;
        } else {
            displayTextView.setText(messageToDisplay);
            isActive = true;
        } */

    }
}
