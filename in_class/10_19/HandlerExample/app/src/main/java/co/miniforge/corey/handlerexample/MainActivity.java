package co.miniforge.corey.handlerexample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText messageEdit;

    int delayAmount = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locateViews();

        bindData();
    }

    private void locateViews() {
        messageEdit = (EditText) findViewById(R.id.messageEditText);
    }

    private void bindData() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),
                        "Hello from runnable!", Toast.LENGTH_SHORT).show();
            }
        };

        handler.postDelayed(runnable, delayAmount);
    }


}
