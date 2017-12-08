package co.corey.filestorageapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import co.corey.filestorageapplication.model.Recipe;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void sharedPrefEdit() {
        String filename = "mySharedPreferences";
        SharedPreferences sharedPref = getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putBoolean("push_notif", true);

        editor.apply();
    }

    public void makeRequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "http://www.recipepuppy.com/api/?q=apple",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray responseArray = response.getJSONArray("results");

                            Recipe recipe1 = new Recipe(responseArray.getJSONObject(0));

                            Toast.makeText(getApplicationContext(), recipe1.title, Toast.LENGTH_LONG).show();
                        } catch (Exception e) {

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        queue.add(jsonObjectRequest);
    }
}
