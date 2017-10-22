package co.miniforge.corey.api_example.AsyncHelper;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MyAsyncHelper {
    ConnectionType connectionType;
    RequestType requestType;

    public MyAsyncHelper(ConnectionType type, RequestType requestType){
        this.connectionType = type;
        this.requestType = requestType;
    }

    public void updateTextviewFromUrl(String url, TextView textView){

    }

    public String getData(String url){
        try {
            return new MyAsyncTask().execute(url).get();
        } catch (Exception e){
            Log.e("TEST", "");
        }

        return "";
    }

    private class MyAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String stringURL = strings[0] != null ? strings[0] : "";
            String result = "";
            HttpURLConnection conn;
            BufferedReader reader;

            try {
                URL url = new URL(stringURL);
                conn = connectionType == ConnectionType.HttpsConnection ?
                        (HttpsURLConnection) url.openConnection() :
                        (HttpURLConnection) url.openConnection();

                if(conn == null) return "";

                conn.setRequestMethod(requestType == RequestType.GET ?
                                        "GET" : "POST");
                conn.connect();

                // Read the input stream into a String
                InputStream inputStream = conn.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Oops nothing returned
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                return buffer.toString();
            } catch (Exception e){
                Log.e("MyAsyncTask", "Error: " + e.getMessage());
                e.printStackTrace();
            }

            return result;
        }
    }
}
