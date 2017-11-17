package co.corey.runnablesandobservables;

import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This runnable is created to update a textview with the contents of an editText
 * every 25ms
 */

public class ChangeTextRunnable implements Runnable {
    private final long delay_time = 25;

    TextView message;
    EditText userInput;
    Handler handler;

    boolean shouldRun = true;

    public ChangeTextRunnable(TextView message, EditText userInput, Handler handler){
        this.message = message;
        this.userInput = userInput;
        this.handler = handler;
    }

    public void stopRunnable(){
        shouldRun = false;
    }

    @Override
    public void run() {
        if(message == null) return;

        if(userInput != null){
            message.setText(userInput.getText());
        }
        else {
            message.setText("Something went wrong!");
        }

        if(shouldRun) handler.postDelayed(this, delay_time);
    }
}
