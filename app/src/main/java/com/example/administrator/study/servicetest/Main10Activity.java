package com.example.administrator.study.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.study.R;

public class Main10Activity extends AppCompatActivity implements View.OnClickListener {
    private Button start;
    private Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        start=(Button)findViewById(R.id.start_service);
        stop=(Button)findViewById(R.id.stop_service);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_service:
                Intent startIntent=new Intent(Main10Activity.this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent=new Intent(Main10Activity.this,MyService.class);
                stopService(stopIntent);
                break;
            default:
                break;
        }
    }
}
