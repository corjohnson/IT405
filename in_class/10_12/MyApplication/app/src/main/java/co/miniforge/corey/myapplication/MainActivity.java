package co.miniforge.corey.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.openURL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String url = "http://www.example.com";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

                String message = "Hello!";
                Intent i2 = new Intent(Intent.ACTION_SEND);
                i2.putExtra(Intent.EXTRA_TEXT, message);
                i2.setType("text/plain");
                startActivity(i2);
            }
        });
    }
}
