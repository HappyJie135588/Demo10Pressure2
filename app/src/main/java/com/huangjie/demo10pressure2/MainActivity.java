package com.huangjie.demo10pressure2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    //private ProgressBar pb_pressure;
    private MyPressureView pressureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //pb_pressure = (ProgressBar) findViewById(R.id.pb_pressure);
        pressureView = (MyPressureView) findViewById(R.id.pressure);
        //pb_pressure.setMax(100);
    }

    public void start(View view) {
        new Thread() {
            @Override
            public void run() {
                startMonitor();
            }
        }.start();

    }

    public void stop(View view) {
        stopMonitor();

    }

    public void setPressure(int pressure) {
        //pressureView.setProgress(pressure);
        pressureView.setPressure(pressure);
    }

    //开始检测压力的本地方法
    public native void startMonitor();

    //停止检测压力的本地方法
    public native void stopMonitor();
}
