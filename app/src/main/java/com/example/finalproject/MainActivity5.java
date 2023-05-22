package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener {

    TextView result;
    String place , movietime , tickettype ,total , food;
    int totalprice;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    static final String[] FROM = new String[] {"content"};
    static final String tb_name = "test";
    ListView lv;
    Button comfirm , backto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        result = (TextView)findViewById(R.id.textView3);
        comfirm = (Button)findViewById(R.id.button2);
        backto = (Button)findViewById(R.id.backto);
        backto.setOnClickListener(this);
        comfirm.setOnClickListener(this);
        Intent it2 = getIntent();
        place = it2.getStringExtra("place");
        movietime = it2.getStringExtra("movietime");
        tickettype = it2.getStringExtra("tickettype");
        total = it2.getStringExtra("total");
        food = it2.getStringExtra("food");
        totalprice = it2.getIntExtra("totalprice",0);
        result.setText("地點:"+place+movietime+"\n"+"票種:"+tickettype+"\n"+"食物:"+food+"\n"+"價錢:"+totalprice);
        lv = (ListView) findViewById(R.id.lv22);
        db = openOrCreateDatabase("content", Context.MODE_PRIVATE,null);
        String createTable = "CREATE TABLE IF NOT EXISTS "+tb_name+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "content VARCHAR(64))";
        db.execSQL(createTable);
        cursor = db.rawQuery("SELECT * FROM "+tb_name,null);
        adapter = new SimpleCursorAdapter(this,R.layout.layout ,cursor, FROM , new int[]{R.id.content},0);
        lv.setAdapter(adapter);
        requery();
        addData(total);
    }
    private void addData(String content)
    {
        ContentValues cv = new ContentValues(1);
        cv.put(FROM[0],content);
        db.insert(tb_name,null,cv);
        requery();
    }
    private void requery()
    {
        cursor = db.rawQuery("SELECT * FROM "+tb_name,null);
        adapter.changeCursor(cursor);
    }

    private void DelData()
    {
        db.delete(tb_name , "_id="+cursor.getInt(0),null);
        requery();
    }

    @Override
    public void onClick(View v)
    {
        if(v == comfirm)
        {
            DelData();
        }
        else if(v == backto)
        {
            Intent intent = new Intent (MainActivity5.this , MainActivity3.class);
            startActivity(intent);
        }

    }
}