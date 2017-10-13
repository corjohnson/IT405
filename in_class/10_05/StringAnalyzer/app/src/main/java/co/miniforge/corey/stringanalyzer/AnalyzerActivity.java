package co.miniforge.corey.stringanalyzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class AnalyzerActivity extends AppCompatActivity {

    String message = "";

    TextView messageTextView;
    Button backToInputButton;

    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyzer);

        getIntentData();

        locateViews();

        bindData();
    }

    void locateViews() {
        this.messageTextView = (TextView) findViewById(R.id.messageTextView);
        this.graphView = (GraphView) findViewById(R.id.graphView);
        this.backToInputButton = (Button) findViewById(R.id.backToInputButton);
    }

    void getIntentData(){
        if(getIntent().hasExtra(InputActivity.intentTag)){
            this.message = getIntent().getStringExtra(InputActivity.intentTag);

            //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    void bindData(){
        messageTextView.setText(message);



        BarGraphSeries<DataPoint> barSeries = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 2),
                new DataPoint(2, 1)
        });

        this.graphView.addSeries(barSeries);
    }
}
