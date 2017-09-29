package com.example.corey.helloworld;

import android.view.View;
import android.widget.Button;

/**
 * Created by corey on 9/28/17.
 */

public class MyButtonClickListener implements View.OnClickListener {
    String message;
    public MyButtonClickListener(String message){
        this.message = message;
    }

    @Override
    public void onClick(View view) {
        ((Button) view).setText(message);
    }
}
