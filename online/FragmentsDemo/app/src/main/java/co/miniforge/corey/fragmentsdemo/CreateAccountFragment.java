package co.miniforge.corey.fragmentsdemo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by corey on 11/9/17.
 */

public class CreateAccountFragment extends Fragment {
    // UI Elements
    EditText username;
    Button createAcctButton;

    //onCreateView -- Called when the fragment is meant to inflate a layout

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //Create view variable from the inflated layout
        View inflated = inflater.inflate(R.layout.create_account_page, container, false);

        locateViews(inflated);

        return inflated;
    }


    //locateViews -- our own function to get a reference to the UI Elements we want to
    // manipulate or change
    void locateViews(View inflated){
        username = inflated.findViewById(R.id.username);
        createAcctButton = inflated.findViewById(R.id.create_account_button);
    }

    //onViewCreated -- Called after onCreateView

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindData();
    }


    //bindData() -- a function to set up click events, data binding, etc
    void bindData(){
        if(createAcctButton != null){
            createAcctButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity mainActivity = (MainActivity)view.getContext();

                    if(mainActivity != null){
                        mainActivity.username = username.getText().toString();

                        mainActivity.showSignIn();
                    }
                }
            });
        }
    }
}
