package com.example.administrator.study.Di9zhang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.study.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView response1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Button send=(Button)findViewById(R.id.send);
        response1=(TextView)findViewById(R.id.response);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.send){
           // sendRequest();
            sendRequestWithOkHttp();
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client=new OkHttpClient();
                try {
                    Request re=new Request.Builder()
                            //.url("http://www.baidu.com")
                            .url("http://10.0.2.2:8081/get_data.json")
                            .build();
                    Response response=client.newCall(re).execute();
                    String responseData=response.body().string();
                    showResponse(responseData);
                    //parseXMLPull(responseData);
                    //parseJSONWithJsonObject(responseData);
                    parseJSONWithGson(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }).start();
    }

    private void parseJSONWithGson(String jsonData) {
        Gson gson=new Gson();
        List<App> appList=gson.fromJson(jsonData,new TypeToken<List<App>>(){}.getType());
        for (App app:appList){
            Log.d("Main8Activity","id is "+app.getId());
            Log.d("Main8Activity","name is "+app.getName());
            Log.d("Main8Activity","version is "+app.getVersion());
        }
    }

    private void parseJSONWithJsonObject(String jsonData) {
        try {
            JSONArray jsonArray=new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                String name=jsonObject.getString("name");
                String version=jsonObject.getString("version");
                Log.d("Main8Activity","id is "+id);
                Log.d("Main8Activity","name is "+name);
                Log.d("Main8Activity","version is "+version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLPull(String xmlData) {
        try {
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser=factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType=xmlPullParser.getEventType();
            String id="";
            String name="";
            String version="";
            while (eventType!=XmlPullParser.END_DOCUMENT){
                String nodeName=xmlPullParser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:{
                        if ("id".equals(nodeName)){
                            id=xmlPullParser.nextText();
                        }
                        else if ("name".equals(nodeName)){
                            name=xmlPullParser.nextText();
                        }
                        else if ("version".equals(nodeName)){
                            version=xmlPullParser.nextText();
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:{
                        if ("app".equals(nodeName)){
                            Log.d("Main8Activity","id is "+id);
                            Log.d("Main8Activity","name is "+name);
                            Log.d("Main8Activity","version is "+version);
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType=xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRequest() {
        //开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                BufferedReader reader=null;
                try {
                    URL url=new URL("http://www.baidu.com");
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in=connection.getInputStream();
                    //下面对获取到的输入流进行读取
                    reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                response1.setText(response);
            }
        });
    }

}
