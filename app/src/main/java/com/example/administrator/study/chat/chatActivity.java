package com.example.administrator.study.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.study.R;

import java.util.ArrayList;
import java.util.List;

public class chatActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initMsgs();
        inputText=(EditText)findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        msgRecyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if (!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPR_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() -1);
                    msgRecyclerView.scrollToPosition(msgList.size() -1);
                    inputText.setText(" ");
                }
            }
        });
    }

    private void initMsgs() {
        Msg m1=new Msg("HIHIHIH",Msg.TYPE_RECEIVED);
        msgList.add(m1);
        Msg m2=new Msg("HIHIHIH",Msg.TYPR_SENT);
        msgList.add(m2);
    }
}
