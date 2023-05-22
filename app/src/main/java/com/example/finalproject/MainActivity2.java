package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {

    Button transbt , rebt , homebt ;
    Spinner theaterspp;
    ImageView thp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        transbt = (Button)findViewById(R.id.transportbt);
        theaterspp = (Spinner)findViewById(R.id.spinnerthea);
        rebt= (Button)findViewById(R.id.rebt);
        thp = (ImageView)findViewById(R.id.imgth);
        homebt = (Button)findViewById(R.id.homebt);

        homebt.setOnClickListener(this);
        transbt.setOnClickListener(this);
        rebt.setOnClickListener(this);
        theaterspp.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == transbt)
        {
            String[] transport = {"大眾交通運輸工具", "汽車"};
            android.app.AlertDialog.Builder bdr3 = new android.app.AlertDialog.Builder(MainActivity2.this);
            bdr3.setTitle("交通方式");
            bdr3.setItems(transport, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            if (theaterspp.getSelectedItem().toString().equals("信義威秀影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=信義威秀影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("東南亞秀泰影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=東南亞秀泰影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台北新光影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台北新光影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("臺中大遠百威秀影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=臺中大遠百威秀影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台中站前秀泰影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台中站前秀泰影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台中新光影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台中新光影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台南大遠百威秀影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台南大遠百威秀影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台南國賓影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台南國賓影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台南新光影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台南新光影城&mode=transit"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);//公車路線
                            }
                        case 1:
                            if (theaterspp.getSelectedItem().toString().contains("信義威秀影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=信義威秀影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);//汽車路線
                            } else if (theaterspp.getSelectedItem().toString().contains("東南亞秀泰影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=東南亞秀泰影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台北新光影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台北新光影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("臺中大遠百威秀影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=臺中大遠百威秀影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台中站前秀泰影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台中站前秀泰影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台中新光影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台中新光影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台南大遠百威秀影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台南大遠百威秀影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台南國賓影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台南國賓影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            } else if (theaterspp.getSelectedItem().toString().contains("台南新光影城")) {
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=台南新光影城&mode=d"));
                                it.setPackage("com.google.android.apps.maps");
                                startActivity(it);
                            }

                    }
                }
            });
            bdr3.show();

        }
        else if(v == rebt)
        {
            if (theaterspp.getSelectedItem().toString().contains("信義威秀影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:25.03547505889496, 121.56695080906178?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("東南亞秀泰影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:25.012921445755524, 121.53608068735433?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("台北新光影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:25.045449304509116, 121.5069507971324?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("臺中大遠百威秀影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.164729982649295, 120.64546577570341?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("台中站前秀泰影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.140555042653535, 120.69085178312827?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("台中新光影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.16494348067797, 120.64400051060503?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("台南大遠百威秀影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.995592939319305, 120.2067989584782?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("台南國賓影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.996602908990894, 120.23495574313185?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            } else if (theaterspp.getSelectedItem().toString().contains("台南新光影城")) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.98702550755962, 120.19948364313174?q=restaurants"));
                it.setPackage("com.google.android.apps.maps");
                startActivity(it);
            }
        }
        else if(v == homebt)
        {
            Intent intent = new Intent (MainActivity2.this , MainActivity3.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
         if(theaterspp.getSelectedItemPosition() == 1)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p1);
         }
         else if(theaterspp.getSelectedItemPosition() == 2)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p2);
         }
         else if(theaterspp.getSelectedItemPosition() == 3)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p3);
         }
         else if(theaterspp.getSelectedItemPosition() == 4)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p4);
         }
         else if(theaterspp.getSelectedItemPosition() == 5)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p5);
         }
         else if(theaterspp.getSelectedItemPosition() == 6)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p6);
         }
         else if(theaterspp.getSelectedItemPosition() == 7)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p7);
         }
         else if(theaterspp.getSelectedItemPosition() == 8)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p8);
         }
         else if(theaterspp.getSelectedItemPosition() == 8)
         {
             thp.setVisibility(View.VISIBLE);
             thp.setImageResource(R.drawable.p8);
         }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}