package com.example.administrator.study.SQLite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.study.R;

public class Main6Activity extends AppCompatActivity {
    private MyDatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        dbhelper=new MyDatabaseHelper(this,"BookStore.db",null,1);
        Button bt1=(Button)findViewById(R.id.create);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelper.getWritableDatabase();
            }
        });
    }
}
