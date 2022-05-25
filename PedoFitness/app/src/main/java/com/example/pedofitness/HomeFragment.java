package com.example.pedofitness;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements SensorEventListener {
    private Integer stepCount = -1;
    private double distance=0,calories=0;
    private double MagnitudePrevious = 0;
    private TextView step,dist,cal;
    private SensorManager sensorManager;
    private Sensor sensor;
    private SharedPreferences sharedPreferences;

    public void restart(){
        stepCount=0;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creating Accelerometer sensor-----
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home3, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        step = view.findViewById(R.id.step_cnt);
        dist = view.findViewById(R.id.dis_cnt);
        cal = view.findViewById(R.id.cal_cnt);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            double Magnitude = Math.sqrt(x*x + y*y +z*z);
            double MagnitudeDelta = Magnitude - MagnitudePrevious;
            MagnitudePrevious = Magnitude;
            if (MagnitudeDelta > 6) {
                stepCount++;
            }
            distance = stepCount * 0.762/1000;
            calories = stepCount * 0.04 ;
            step.setText(stepCount.toString());
            dist.setText(String.format("%.2f Km", distance));
            cal.setText(String.format("%.1f Cal", calories));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences = getActivity().getPreferences(0);
        stepCount = sharedPreferences.getInt("stepCount", 0);
        sensorManager.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onPause() {
        super.onPause();
        sharedPreferences = getActivity().getPreferences(0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("stepCount", stepCount);
        editor.apply();
        sensorManager.unregisterListener((SensorEventListener) this);
    }

//    protected void onStop() {
//        super.onStop();
//
//        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.putInt("stepCount", stepCount);
//        editor.apply();
//    }

}