package co.miniforge.corey.api_example;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import co.miniforge.corey.api_example.AsyncHelper.ConnectionType;
import co.miniforge.corey.api_example.AsyncHelper.MyAsyncHelper;
import co.miniforge.corey.api_example.AsyncHelper.RequestType;
import co.miniforge.corey.api_example.model.Recipe;

public class MainActivity extends AppCompatActivity {
    EditText edit_query;
    TextView responseDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Handler handler = new Handler();
//        MyRunnable runnable = new MyRunnable(handler);
//        handler.post(runnable);

        edit_query = (EditText) findViewById(R.id.edit_query);

        responseDisplay = (TextView) findViewById(R.id.responseTextview);

        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runRunnable();
            }
        });

    }

    void runRunnable(){
        final MyAsyncHelper helper = new MyAsyncHelper(ConnectionType.HttpsConnection, RequestType.GET);
        HandlerThread thread = new HandlerThread("Test");
        thread.start();
        Handler threadHandler = new Handler(thread.getLooper());

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                String textData = edit_query.getText().toString();

                //Log.i("HELLO", helper.getData("https://wt-009118fe5913a9a73c82768e11abf7ea-0.run.webtask.io/greeter"));
                //String s = helper.getData("http://www.recipepuppy.com/api/?q=" + textData.trim());
                String s = helper.getData("https://wt-009118fe5913a9a73c82768e11abf7ea-0.run.webtask.io/greeter");

                try {
                    JSONObject apiCallResult = new JSONObject(s);
                    responseDisplay.setText(apiCallResult.getString("data"));

//                    JSONArray recipes = apiCallResult.getJSONArray("results");
//                    List<Recipe> recipeList = new LinkedList<>();
//
//                    for(int i = 0; i < recipes.length(); i++){
//                        recipeList.add(new Recipe(recipes.getJSONObject(i)));
//                    }
//
//                    responseDisplay.setText(recipeList.get(0).toString());
                } catch (Exception e){

                }
            }
        };

        threadHandler.post(runnable1);
    }
}
