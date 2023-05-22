package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity implements View.OnClickListener {
         TextView f9 , f9video , man , manvideo , topgun , topgunvideo , widows , widowsvideo;
         Button back , timesearch6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        f9 = (TextView)findViewById(R.id.f9);
        f9video = (TextView)findViewById(R.id.f9video);
        manvideo = (TextView)findViewById(R.id.manvideo);
        topgunvideo = (TextView)findViewById(R.id.topgunvideo);
        widowsvideo = (TextView)findViewById(R.id.widowsvideo);
        back = (Button)findViewById(R.id.back);
        timesearch6 = (Button)findViewById(R.id.timesearch6);
        f9video.setMovementMethod(LinkMovementMethod.getInstance());
        manvideo.setMovementMethod(LinkMovementMethod.getInstance());
        topgunvideo.setMovementMethod(LinkMovementMethod.getInstance());
        widowsvideo.setMovementMethod(LinkMovementMethod.getInstance());
        back.setOnClickListener(this);
        timesearch6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == back)
        {
            Intent intent = new Intent (MainActivity6.this , MainActivity3.class);
            startActivity(intent);
        }
        else if(v == timesearch6)
        {
            Intent intent = new Intent (MainActivity6.this , MainActivity4.class);
            startActivity(intent);
        }
    }
}