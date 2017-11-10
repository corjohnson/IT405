package co.miniforge.corey.fragmentsdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by corey on 11/9/17.
 */

public class SignInFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflated = inflater.inflate(R.layout.sign_in_page, container, false);

        return inflated;
    }
}
