package co.miniforge.corey.fragmentsdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by corey on 11/9/17.
 */

public class MainActivity extends AppCompatActivity {
    //Create a string that represents the username
    public String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCreateAccount();
    }

    public void login(String enteredUsername){
        if(username.trim().equals(enteredUsername.trim())){
            Intent intent = new Intent(this, HomeContentActivity.class);
            startActivity(intent);
        }
    }

    public void showSignIn(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = new SignInFragment();
        transaction.replace(R.id.fragmentContainer, fragment);

        transaction.commit();
    }

    public void showCreateAccount(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = new CreateAccountFragment();
        transaction.replace(R.id.fragmentContainer, fragment);

        transaction.commit();
    }
}

