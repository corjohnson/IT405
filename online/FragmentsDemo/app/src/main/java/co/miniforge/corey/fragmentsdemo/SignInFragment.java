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
import android.widget.Toast;

/**
 * Created by corey on 11/9/17.
 */

public class SignInFragment extends Fragment {
    //Elements in the layout we inflate
    EditText username;
    EditText password;

    Button loginButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflated = inflater.inflate(R.layout.sign_in_page, container, false);

        locateViews(inflated);

        return inflated;
    }

    void locateViews(View inflated){
        username = inflated.findViewById(R.id.username);
        password = inflated.findViewById(R.id.password);

        loginButton = inflated.findViewById(R.id.login_button);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindData();
    }

    void bindData() {
        if(loginButton != null){
            final Fragment fragment = this;

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(), HomeContentActivity.class);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
