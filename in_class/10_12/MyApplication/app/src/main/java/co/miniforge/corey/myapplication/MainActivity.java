package co.miniforge.corey.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.openURL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String url = "http://www.example.com";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

                /*String message = "Hello!";
                Intent i2 = new Intent(Intent.ACTION_SEND);
                i2.putExtra(Intent.EXTRA_TEXT, message);
                i2.setType("text/plain");
                startActivity(i2);*/

                /* Requires compile 'com.android.support:design:26.+' in the app build.gradle */
                Snackbar.make(button, "My snackbar", Snackbar.LENGTH_SHORT).show();
            }
        });


        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        String url = "https://image.freepik.com/free-psd/white-mobile-phone-mock-up_1104-79.jpg";
        Glide.with(this).load(url).into(imageView);
    }
}








