package com.example.oh.project14;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
/*    String SERVER_IP = "192.168.56.1";
    int SERVER_PORT = 200;
    String msg = "";
    EditText e1;*/
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* e1 = (EditText)findViewById(R.id.etmsg);
        myThread.start();*/
    }
    public void onClick(View v){
       // msg = e1.getText().toString();
        switch (v.getId()){
            case R.id.project2 :
                intent = new Intent(this, ReadingWebpage.class);
                startActivity(intent);
                break;
            case R.id.project3 :
                intent = new Intent(this, ReadingRSS.class);
                startActivity(intent);
                break;
            case R.id.project4 :
                intent = new Intent(this, LoginApp.class);
                startActivity(intent);
                break;
        }

    }

    /*Handler myHandler = new Handler();
    Thread myThread = new Thread(){
        @Override
        public void run() {
            try {
                Socket aSocket = new Socket(SERVER_IP, SERVER_PORT);

                Scanner s = new Scanner(System.in);
                String msg = s.next();

                ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
                outstream.writeObject(msg);
                outstream.flush();

                ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
                final Object obj = instream.readObject();

                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), (String) obj, Toast.LENGTH_SHORT).show();
                    }
                });


                aSocket.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    };*/
}
