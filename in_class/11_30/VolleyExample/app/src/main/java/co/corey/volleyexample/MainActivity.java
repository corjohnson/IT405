package co.corey.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    RequestQueue queue;

    private final String api_url = "http://www.recipepuppy.com/api/?i=onions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseText = findViewById(R.id.responseText);
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                api_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Convert the string response to a json object
                            JSONObject jsonObject = new JSONObject(response);

                            //Get the json array from results
                            JSONArray resultsArray = jsonObject.getJSONArray("results");

                            //Pull the first json object from the array
                            JSONObject firstObject = resultsArray.getJSONObject(0);

                            responseText.setText(firstObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

//                        responseText.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responseText.setText("Something went wrong!");
                    }
                }
        );

        queue.add(stringRequest);
    }
}
