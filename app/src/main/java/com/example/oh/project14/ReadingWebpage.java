package com.example.oh.project14;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ReadingWebpage extends AppCompatActivity {
    EditText e2;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_webpage);
        e2 = (EditText)findViewById(R.id.e2);
        t2 = (TextView)findViewById(R.id.textView);
        setTitle("Reading Webpage");
    }

    public void onClick(View v){
        thread.start();
    }

    Handler handler = new Handler();
    Thread thread = new Thread(){
        @Override
        public void run() {
            try {
                String urlstr = e2.getText().toString();
                URL url = new URL(urlstr);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    final String data = readData(urlConnection.getInputStream());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            t2.setText(data);
                        }
                    });
                    urlConnection.disconnect();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String readData(InputStream is) {
            String data = "";
            Scanner s = new Scanner(is);
            while (s.hasNext())
                data += s.nextLine() + "\n";
            s.close();
            return data;
        }
    };
}
