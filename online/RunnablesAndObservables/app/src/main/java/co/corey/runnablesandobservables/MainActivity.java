package co.corey.runnablesandobservables;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView message;
    EditText editText;
    Button button;

    ChangeTextRunnable changeText;

    Runnable tbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        editText = findViewById(R.id.editText);

        Handler handler = new Handler();
        changeText = new ChangeTextRunnable(message, editText, handler);
        handler.post(changeText);
    }

}
