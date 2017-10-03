package corey.buttons;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //Fields
    Button button;
    ToggleButton toggleButton;
    RadioButton radioButton;
    ImageButton imageButton;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locateViews();

        customizeButton();

        customizeImageButton();

        customizeToggleButton();

        customizeCheckbox();
    }

    /**
     *  locateViews - Used to fetch the views from the layout (since findViewById is an expensive
     *  function to call multiple times)
     */
    private void locateViews(){
        button = (Button) findViewById(R.id.button);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
    }

    /**
     * Customizing various attributes for buttons
     * Please refer to the link below if you are looking for more information
     * https://developer.android.com/reference/android/widget/Button.html
     */
    private void customizeButton(){
        //Set the background color
        button.setBackgroundColor(Color.parseColor("#b4b4b4"));

        //Set the text
        button.setText("This is a button!");

        //Inline button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Toast message from within button click", Toast.LENGTH_SHORT).show();
            }
        });

        //Enable/Disable the button so that you can't click it
        button.setEnabled(false);

        //Set padding for the button (basically think of this like padding around the text of the button)
        //Please note, padding is in pixels, not dp. I will be providing a simple util that can convert
        //px to dp soon.
        button.setPadding(10, 10, 10, 10);

        //Set button text color
        button.setTextColor(Color.parseColor("#ffffff"));
    }

    /**
     * Customize the toggle button
     * https://developer.android.com/guide/topics/ui/controls/togglebutton.html
     */
    private void customizeToggleButton() {
        /* Toggle buttons, switches, and checkboxes work very similar. I'm not going to re-write a bunch
           of explanations for it. */
        toggleButton.setChecked(false);
    }

    /**
     * Customizing image button
     * https://developer.android.com/reference/android/widget/ImageButton.html
     */
    private void customizeImageButton(){
        //Works very similar to button, but image buttons have an image as the background resource

        //Set the image resource
        imageButton.setImageResource(R.drawable.simple_button_shape);
    }

    /**
     * Checkbox - Used to customize checkbox properties
     * For additional information please see:
     * https://developer.android.com/guide/topics/ui/controls/checkbox.html
     */
    private void customizeCheckbox() {
        //Set the checkbox to a specific checked state
        checkBox.setChecked(true);

        //Set the label for the checkbox
        checkBox.setText("My Checkbox");

        //Set a checked state change listener
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(getApplicationContext(),
                        "Checkbox state changed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
