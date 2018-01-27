package com.example.administrator.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.study.chat.chatActivity;

import java.util.ArrayList;
import java.util.List;




public class Main3Activity extends AppCompatActivity {
    private List<Listt> listt=new ArrayList<>();
    private ListView listview;
    //private String[] data={"a","s","d","f","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(Main3Activity.this,android.R.layout.simple_list_item_1,data);
        listview=(ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);*/
        initlist();
        ListAdapter adapter=new ListAdapter(Main3Activity.this,R.layout.list_item,listt);
        listview=(ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Listt list=listt.get(i);
                Toast.makeText(Main3Activity.this,list.getName(),Toast.LENGTH_SHORT).show();
                Intent t=new Intent(Main3Activity.this,chatActivity.class);
                startActivity(t);
            }
        });
    }

    private void initlist() {
        for(int i=0;i<2;i++){
            Listt a=new Listt("aaa",R.drawable.library);
            listt.add(a);
            Listt b=new Listt("bbb",R.drawable.user1);
            listt.add(b);
            Listt c=new Listt("ccc",R.drawable.user2);
            listt.add(c);
            Listt d=new Listt("ddd",R.drawable.user3);
            listt.add(d);
        }
    }
}
