package com.example.administrator.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button)findViewById(R.id.button1);
        Button bt2=(Button)findViewById(R.id.bt2);
        final ImageView img1=(ImageView)findViewById(R.id.img1);
        pb=(ProgressBar)findViewById(R.id.pb);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pb.getVisibility()==View.GONE){
                    pb.setVisibility(View.VISIBLE);
                }
                else {
                    pb.setVisibility(View.GONE);
                }
                int progress=pb.getProgress();
                progress=progress+10;
                pb.setProgress(progress);
                Toast.makeText(MainActivity.this,"123",Toast.LENGTH_SHORT).show();
                img1.setImageResource(R.drawable.library);
               /* Intent t=new Intent(Intent.ACTION_VIEW);
                t.setData(Uri.parse("http://www.baidu.com"));
                startActivity(t);*/
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data="helloman";
                Intent t=new Intent(MainActivity.this,Main2Activity.class);
                t.putExtra("extra_data",data);
                startActivity(t);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove:
                Toast.makeText(this,"222",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
