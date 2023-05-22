package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button timesearch , theatersearch , orderticket , videosearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        timesearch = (Button)findViewById(R.id.timesearch);
        theatersearch = (Button)findViewById(R.id.theatersearch);
        orderticket = (Button)findViewById(R.id.orderticket);
        videosearch = (Button)findViewById(R.id.videosearch);

        orderticket.setOnClickListener(this);
        timesearch.setOnClickListener(this);
        theatersearch.setOnClickListener(this);
        videosearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == timesearch)
        {
            Intent intent = new Intent (MainActivity3.this , MainActivity4.class);
            startActivity(intent);
        }
        else if(v == theatersearch )
        {
            Intent intent = new Intent (MainActivity3.this , MainActivity2.class);
            startActivity(intent);
        }
        else if(v == orderticket)
        {
            Intent intent = new Intent (MainActivity3.this , MainActivity5.class);
            startActivity(intent);
        }
        else if(v == videosearch)
        {
            Intent intent = new Intent (MainActivity3.this , MainActivity6.class);
            startActivity(intent);
        }

    }
}