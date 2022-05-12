package com.example.pedofitness;
//// This part of code is the defualt code ///
/* 
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

*/


/* Below code is newly updated code also have some lines of code which does'nt relate t our project so plz while running the code take (circle part code only ) and remove other part */
/*
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {


    private int CurrentProgress = 0;
    private ProgressBar progressBar;
    private Button StartProgress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = findViewById(R.id.progressBar);
        StartProgress = findViewById(R.id.startProgess);

        final CountDownTimer countDownTimer = new CountDownTimer(11*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                CurrentProgress = CurrentProgress + 10;
                progressBar.setProgress(CurrentProgress);
                progressBar.setMax(100);

            }

            @Override
            public void onFinish() {

            }
        };

        StartProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countDownTimer.start();
            }
        });


    }
}
*/
