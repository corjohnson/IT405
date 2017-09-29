package com.example.corey.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    TextView textView;
    //Code after this

        textView = (TextView) findViewById(R.id.textView);

        textView.setText("Goodbye class");

        final Button button = (Button) findViewById(R.id.button);
        button.setText(getString(R.string.button_text));
        MyButtonClickListener listener = new MyButtonClickListener("I was clicked");
        button.setOnClickListener(listener);

        //Toast
        Toast.makeText(this, "Hello from toast", Toast.LENGTH_SHORT).show();
        //Log
        Log.i("MyTag", "Log log");
        //Snackbar

        */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_test);

        View view = findViewById(R.id.button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
