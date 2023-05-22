package com.example.finalproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity4 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener , View.OnClickListener , AdapterView.OnItemSelectedListener , AdapterView.OnItemClickListener {

    String date;
    TextView theatertvt;
    Calendar c;
    Spinner spwmovie , spithea;
    ImageView imgmovie;
    ListView timeslv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        c = Calendar.getInstance();
        theatertvt = (TextView) findViewById(R.id.theatertvt);
        spwmovie = (Spinner)findViewById(R.id.spwmovie);
        spithea = (Spinner)findViewById(R.id.spithea);
        imgmovie = (ImageView)findViewById(R.id.imgmovie);
        timeslv = (ListView) findViewById(R.id.timeslv);

        spwmovie.setOnItemSelectedListener(this);
        spithea.setOnItemSelectedListener(this);
        timeslv.setOnItemClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        date = year+"/"+(month+1)+"/"+dayOfMonth;
        theatertvt.setText(date);
    }

    @Override
    public void onClick(View v) {
        if(v == theatertvt){
            new DatePickerDialog(this, this,
                    c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<String> list4 = new ArrayList<String>();
        String[] action4;
        if(parent.getId() == R.id.spwmovie)
        {
            if(spwmovie.getSelectedItemPosition() == 1)
            {
                imgmovie.setImageResource(R.drawable.f9);
                action4 = getResources().getStringArray(R.array.玩命關頭9);
                for (int j = 0; j < action4.length; j++) {
                    list4.add(action4[j]);
                }
                ArrayAdapter<String> adapter4 = new ArrayAdapter(this, android.R.layout.simple_gallery_item, list4);
                adapter4.setDropDownViewResource(android.R.layout.simple_gallery_item);
                timeslv.setAdapter(adapter4);
            }
            else if(spwmovie.getSelectedItemPosition() == 2)
            {
                imgmovie.setImageResource(R.drawable.man);
                action4 = getResources().getStringArray(R.array.當男人戀愛時);
                for (int j = 0; j < action4.length; j++) {
                    list4.add(action4[j]);
                }
                ArrayAdapter<String> adapter4 = new ArrayAdapter(this, android.R.layout.simple_gallery_item, list4);
                adapter4.setDropDownViewResource(android.R.layout.simple_gallery_item);
                timeslv.setAdapter(adapter4);
            }
            else if(spwmovie.getSelectedItemPosition() == 3)
            {
                imgmovie.setImageResource(R.drawable.topgun2);
                action4 = getResources().getStringArray(R.array.捍衛戰士獨行俠);
                for (int j = 0; j < action4.length; j++) {
                    list4.add(action4[j]);
                }
                ArrayAdapter<String> adapter4 = new ArrayAdapter(this, android.R.layout.simple_gallery_item, list4);
                adapter4.setDropDownViewResource(android.R.layout.simple_gallery_item);
                timeslv.setAdapter(adapter4);
            }
            else if(spwmovie.getSelectedItemPosition() == 4)
            {
                imgmovie.setImageResource(R.drawable.blackwidows);
                action4 = getResources().getStringArray(R.array.黑寡婦);
                for (int j = 0; j < action4.length; j++) {
                    list4.add(action4[j]);
                }
                ArrayAdapter<String> adapter4 = new ArrayAdapter(this, android.R.layout.simple_gallery_item, list4);
                adapter4.setDropDownViewResource(android.R.layout.simple_gallery_item);
                timeslv.setAdapter(adapter4);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        TextView txv = (TextView) view;
        android.app.AlertDialog.Builder bdr2 = new android.app.AlertDialog.Builder(this);
        bdr2.setMessage(theatertvt.getText().toString()+" "+spithea.getSelectedItem().toString()+" "+spwmovie.getSelectedItem().toString()+" "+txv.getText().toString());
        bdr2.setTitle("前往訂票頁面");
        bdr2.setPositiveButton("前往訂票", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("movie",spwmovie.getSelectedItem().toString());
                intent.putExtra("theater",spithea.getSelectedItem().toString());
                intent.putExtra("time",theatertvt.getText().toString());
                intent.putExtra("listview",position);
                startActivity(intent);
            }
        });
        bdr2.show();
    }
}