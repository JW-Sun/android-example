package com.example.administrator.study.AndroidThreadTest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.study.R;

public class Main9Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView text;
    public static final int UPDATE_TEXT=1;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    text.setText("Nice Supreme");
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        text=(TextView)findViewById(R.id.textt);
        Button changetext=(Button)findViewById(R.id.change_text);
        changetext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_text:{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       Message message=new Message();
                        message.what=UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            }
            default:
                break;
        }
    }
}
