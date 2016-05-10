package com.example.administrator.test60;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
private String url ;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = "http://api.avatardata.cn/GuoNeiNews/Query?key=45eeea2f8c674cfab306a26441242d91&page=1&rows=10";


        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet get = new HttpGet("url");
                    HttpResponse response = client.execute(get);
                    HttpEntity entity = response.getEntity();
                    final String s = EntityUtils.toString(entity);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("result-----", s);

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }.start();

    }
}
