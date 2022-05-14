package com.example.pedofitness;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    // creating menu-------------

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.home:
                setContentView(R.layout.activity_main);
                return true;
            case R.id.goal:
                setContentView(R.layout.mygoal);
                return true;
            case R.id.profile:
                setContentView(R.layout.myprofile);
                return true;
            case R.id.report:
                setContentView(R.layout.myreport);
                return true;
            case R.id.about:
                setContentView(R.layout.myabout);
                return true;
            default:
                return true;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater=getMenuInflater();
        Inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
////// This part of code is the defualt code ///
///*
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
//
//*/
//
//
///* Below code is newly updated code also have some lines of code which does'nt relate t our project so plz while running the code take (circle part code only ) and remove other part */
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//
//
//public class MainActivity extends AppCompatActivity {
//
//
//    private int CurrentProgress = 0;
//    private ProgressBar progressBar;
//    private Button StartProgress;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        progressBar = findViewById(R.id.progressBar);
//        StartProgress = findViewById(R.id.startProgess);
//
//        final CountDownTimer countDownTimer = new CountDownTimer(11*1000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                CurrentProgress = CurrentProgress + 10;
//                progressBar.setProgress(CurrentProgress);
//                progressBar.setMax(100);
//
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        };
//
//        StartProgress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                countDownTimer.start();
//            }
//        });
//
//
//    }
//}
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private ProgressBar progressBar;
//    private TextView progressText;
//    int i = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // set the id for the progressbar and progress text
//        progressBar = findViewById(R.id.progress_bar);
//        progressText = findViewById(R.id.progress_text);
//
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // set the limitations for the numeric
//                // text under the progress bar
//                if (i <= 100) {
//                    progressText.setText("" + i);
//                    progressBar.setProgress(i);
//                    i++;
//                    handler.postDelayed(this, 200);
//                } else {
//                    handler.removeCallbacks(this);
//                }
//            }
//        }, 200);
//    }
//}
