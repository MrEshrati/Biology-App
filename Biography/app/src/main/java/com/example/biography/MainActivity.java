package com.example.biography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Integer a = 0;

    ProgressBar progressBar;

    Timer timer;
    TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.MainProgressBar);

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

                if (a == 0){

                    a = a + 1;


                }

                else {

                    timer.cancel();

                    progressBar.setVisibility(View.INVISIBLE);

                    Intent intent = new Intent(MainActivity.this , PdfView.class);
                    startActivity(intent);
                }
            }
        };

        timer.scheduleAtFixedRate(task , 0 , 3000);
    }
}