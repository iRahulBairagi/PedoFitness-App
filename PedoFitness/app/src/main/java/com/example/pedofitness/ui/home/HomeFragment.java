package com.example.pedofitness.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pedofitness.R;

public class HomeFragment extends Fragment implements SensorEventListener {
    private Integer stepCount = -1;
    private double distance=0,calories=0;
    private double MagnitudePrevious = 0;
    private TextView textView6,textView4,textView5;
    private SensorManager sensorManager;
    private Sensor sensor;
    private SharedPreferences sharedPreferences;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Accelerometer sensor part
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    //    protected void onPause() {
//        super.onPause();
//        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.putInt("stepCount", stepCount);
//        editor.apply();
//    }
//    protected void onStop() {
//        super.onStop();
//
//        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.putInt("stepCount", stepCount);
//        editor.apply();
//    }
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
//        stepCount = sharedPreferences.getInt("stepCount", 0);
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home3, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView6 = view.findViewById(R.id.textView6);
        textView4 = view.findViewById(R.id.textView4);
        textView5 = view.findViewById(R.id.textView5);
    }

    //    SensorEventListener stepDetector = new SensorEventListener() {
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            float x_acceleration = sensorEvent.values[0];
            float y_acceleration = sensorEvent.values[1];
            float z_acceleration = sensorEvent.values[2];
            double Magnitude = Math.sqrt(x_acceleration * x_acceleration + y_acceleration * y_acceleration + z_acceleration * z_acceleration);
            double MagnitudeDelta = Magnitude - MagnitudePrevious;
            MagnitudePrevious = Magnitude;
            if (MagnitudeDelta > 6) {
                stepCount++;
            }
            distance = stepCount * 0.762/1000;
            calories = stepCount * 0.04 ;
            textView6.setText(stepCount.toString());
            textView4.setText(String.format("%.2f Km", distance));
            textView5.setText(String.format("%.1f Cal", calories));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }

        //sensorManager.registerListener(stepDetector, sensor, SensorManager.SENSOR_DELAY_NORMAL);
}