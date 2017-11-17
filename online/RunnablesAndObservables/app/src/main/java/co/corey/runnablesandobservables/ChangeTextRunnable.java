package co.corey.runnablesandobservables;

import android.widget.TextView;

/**
 * Created by corey on 11/16/17.
 */

public class ChangeTextRunnable implements Runnable {

    TextView message;
    String newText;

    public ChangeTextRunnable(TextView message) {
        this(message, "");
    }

    public ChangeTextRunnable(TextView message, String newText){
        this.message = message;
        this.newText = newText;
    }

    @Override
    public void run() {
        if(message == null) return;

        message.setText(newText);
    }

    public void updateMessage(String newText){
        this.newText = newText;
    }
}
