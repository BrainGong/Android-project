package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity7 extends AppCompatActivity implements View.OnClickListener {
      ImageView imgtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        imgtitle = (ImageView)findViewById(R.id.imageViewTitle);
        imgtitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == imgtitle)
        {
            Intent intent = new Intent (MainActivity7.this , MainActivity3.class);
            startActivity(intent);
        }
    }
}