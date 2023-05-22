package com.example.finalproject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher , View.OnClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, DatePickerDialog.OnDateSetListener{
     TextView   tvdate , tvchoice;
     ListView lvfood;
     Spinner splocation , sptheater , spmovie , spwhen , spchild , spadult ,spearly;
     Button btcomfirm ;
     Calendar c;
     String totalfood;
     ArrayList<String> foodselected = new ArrayList<>();
     String tickettypes , getTotalfoods = "" , where , total , ticket = "";
     String childticket , adultticket , earlyticket;
     int getFoodprice , getTicketprice , gettotalprice;
     int popprice = 0 ,popsum = 0 ,extprice = 0 ,extsum = 0 ,hotprice = 0 ,hotsum = 0 ,driprice = 0 ,drisum = 0 ,cofprice = 0 ,cofsum = 0;
     int adultprice , childprice , earlyprice;
     String movietime;
    String theaterw;
    int lvindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = Calendar.getInstance();
        tvdate = (TextView)findViewById(R.id.tvdate);
        tvchoice = (TextView)findViewById(R.id.tvchoice);
        lvfood = (ListView)findViewById(R.id.lvfood);
        splocation = (Spinner)findViewById(R.id.splocation);
        sptheater = (Spinner)findViewById(R.id.sptheater);
        spmovie = (Spinner)findViewById(R.id.spmovie);
        spwhen = (Spinner)findViewById(R.id.spwhen);
        spadult = (Spinner)findViewById(R.id.spadult);
        spchild = (Spinner)findViewById(R.id.spchild);
        spearly = (Spinner)findViewById(R.id.spearly);
        btcomfirm = (Button)findViewById(R.id.btcomfirm);


        btcomfirm.setOnClickListener(this);
        splocation.setOnItemSelectedListener(this);
        sptheater.setOnItemSelectedListener(this);
        spadult.setOnItemSelectedListener(this);
        spchild.setOnItemSelectedListener(this);
        spmovie.setOnItemSelectedListener(this);
        spearly.setOnItemSelectedListener(this);
        spwhen.setOnItemSelectedListener(this);
        lvfood.setOnItemClickListener(this);
        Intent it = getIntent();
        String moview = it.getStringExtra("movie");
        theaterw = it.getStringExtra("theater");
        String timew = it.getStringExtra("time");
        lvindex = it.getIntExtra("listview",0);

        tvdate.setText(timew);
        if(moview.equals("玩命關頭9"))
        {
            spmovie.setSelection(1);
        }
        else if (moview.equals("當男人戀愛時"))
        {
            spmovie.setSelection(2);
        }
        else if (moview.equals("捍衛戰士2:獨行俠"))
        {
            spmovie.setSelection(3);
        }
        else if (moview.equals("黑寡婦"))
        {
            spmovie.setSelection(4);
        }
        if(theaterw.equals("信義威秀影城"))
        {
            splocation.setSelection(0);
        }
        else if(theaterw.equals("東南亞秀泰影城"))
        {
            splocation.setSelection(0);
        }
        else if(theaterw.equals("台北新光影城"))
        {
            splocation.setSelection(0);
        }
        else if(theaterw.equals("臺中大遠百威秀影城"))
        {
            splocation.setSelection(1);
        }
        else if(theaterw.equals("台中站前秀泰影城"))
        {
            splocation.setSelection(1);
        }
        else if(theaterw.equals("台中新光影城"))
        {
            splocation.setSelection(1);
        }
        else if(theaterw.equals("台南大遠百威秀影城"))
        {
            splocation.setSelection(2);
        }
        else if(theaterw.equals("台南國賓影城"))
        {
            splocation.setSelection(2);
        }
        else if(theaterw.equals("台南新光影城"))
        {
            splocation.setSelection(2);
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s)
    {
        textchange();
    }

    @Override
    public void onClick(View v) {
        if(v == tvdate){
            new DatePickerDialog(this, this,
                    c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if(v == btcomfirm)
        {
            Intent intent2 = new Intent(getApplicationContext(), MainActivity5.class);//傳值至訂票紀錄頁面
            intent2.putExtra("place",where);
            intent2.putExtra("movietime",movietime);
            intent2.putExtra("tickettype",ticket);
            intent2.putExtra("food",getTotalfoods);
            intent2.putExtra("totalprice",gettotalprice);
            intent2.putExtra("total",total);
            startActivity(intent2);
        }

    }
    private void textchange() {
        where = splocation.getSelectedItem().toString()+sptheater.getSelectedItem().toString();
        gettotalprice = getFoodprice+getTicketprice;
        total  = where+movietime+ticket+"\n"+getTotalfoods+"\n"+"總共價格為:"+gettotalprice;
        tvchoice.setText(total);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        tvdate.setText(year+"/"+(month+1)+"/"+dayOfMonth);
        textchange();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView foodchoice = (TextView)view;
        //image.setImageResource(R.drawable.popcorn);
        String foodcc = foodchoice.getText().toString();
        String [] popcorntype = new String[] {"甜" , "鹹" , "大" , "中"};
        String [] extrastype = new String[] {"原味" , "巧克力"};
        String [] hotdogtype = new String[] {"大" , "中" , "小" };
        String [] drinktype = new String[] {"大" , "中" , "小" , "去冰" ,"正常冰" , "少冰"};
        String [] coffeetype = new String[] {"冰" , "熱" , "大" , "中" , "小"};
        String [] quantity = new String[]{"1","2","3","4"};
        boolean[] pop = new boolean[popcorntype.length];
        boolean[] ext = new boolean[extrastype.length];
        boolean[] hot = new boolean[hotdogtype.length];
        boolean[] dri = new boolean[drinktype.length];
        boolean[] cof = new boolean[coffeetype.length];
        if(foodcc.equals("爆米花"))
        {
            android.app.AlertDialog.Builder bdr2 = new android.app.AlertDialog.Builder(MainActivity.this);
            bdr2.setTitle("爆米花");
            bdr2.setIcon(R.drawable.popcorn);
            bdr2.setMultiChoiceItems(popcorntype, pop, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    pop[which] = isChecked;
                }//食物種類選擇
            });
            bdr2.setNegativeButton("選擇數量", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    android.app.AlertDialog.Builder bdr = new android.app.AlertDialog.Builder(MainActivity.this);
                    bdr.setTitle("數量");
                    bdr.setSingleChoiceItems(quantity, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods += " "+quantity[which]+"桶";
                            popsum = Integer.parseInt(quantity[which]);
                        }
                    });
                    bdr.setNegativeButton("確認訂單", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods+=" "+"爆米花"+" ";

                            for(int i = 0 ; i< pop.length ; i++)
                            {
                                if(pop[i]==true)
                                {
                                    if(popcorntype[i].contains("鹹")||popcorntype[i].contains("甜"))
                                    {
                                        getTotalfoods+="口味:"+popcorntype[i]+" ";
                                    }
                                    else
                                        getTotalfoods+="Size:"+popcorntype[i];
                                    if(popcorntype[i].contains("大"))
                                    {
                                        popprice+=180;
                                    }
                                    else if(popcorntype[i].contains("中"))
                                    {
                                        popprice+=130;
                                    }
                                    getFoodprice+=popprice*popsum;
                                    textchange();
                                }
                            }
                            getTotalfoods+=" ";
                        }
                    });
                    bdr.show();
                }
            });
            bdr2.show();
            popsum = 0;
            popprice = 0;
        }
        else if(foodcc.equals("吉拿棒"))
        {
            android.app.AlertDialog.Builder bdr2 = new android.app.AlertDialog.Builder(MainActivity.this);
            bdr2.setTitle("吉拿棒");
            bdr2.setIcon(R.drawable.extra);
            bdr2.setMultiChoiceItems(extrastype, ext, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    ext[which] = isChecked;
                }
            });
            bdr2.setNegativeButton("選擇數量", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    android.app.AlertDialog.Builder bdr = new android.app.AlertDialog.Builder(MainActivity.this);
                    bdr.setTitle("數量");
                    bdr.setSingleChoiceItems(quantity, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods += " "+quantity[which]+"支";
                            extsum = Integer.parseInt(quantity[which]);
                        }
                    });
                    bdr.setNegativeButton("確認訂單", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods+=" "+"吉拿棒"+" ";
                            for(int i = 0 ; i< ext.length ; i++)
                            {
                                if(ext[i]==true)
                                {
                                    getTotalfoods+="口味:"+extrastype[i];
                                    extprice+=139;
                                    getFoodprice+=extprice*extsum;
                                    textchange();
                                }
                            }
                            getTotalfoods+=" ";
                        }
                    });
                    bdr.show();
                }
            });
            bdr2.show();
            extprice = 0;
            extsum = 0;
        }
        else if(foodcc.equals("熱狗堡"))
        {
            android.app.AlertDialog.Builder bdr2 = new android.app.AlertDialog.Builder(MainActivity.this);
            bdr2.setTitle("熱狗堡");
            bdr2.setIcon(R.drawable.hotdog);
            bdr2.setMultiChoiceItems(hotdogtype, hot, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    hot[which] = isChecked;
                }
            });
            bdr2.setNegativeButton("選擇數量", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    android.app.AlertDialog.Builder bdr = new android.app.AlertDialog.Builder(MainActivity.this);
                    bdr.setTitle("數量");
                    bdr.setSingleChoiceItems(quantity, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods += " "+quantity[which]+"個";
                            hotsum = Integer.parseInt(quantity[which]);
                        }
                    });
                    bdr.setNegativeButton("確認訂單", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods+=" "+"熱狗堡"+" ";
                            for(int i = 0 ; i< hot.length ; i++)
                            {
                                if(hot[i]==true)
                                {
                                    getTotalfoods+="Size:"+hotdogtype[i];
                                    if(hotdogtype[i].contains("大"))
                                    {
                                        hotprice +=80;
                                    }
                                    else if(hotdogtype[i].contains("中"))
                                    {
                                        hotprice +=60;
                                    }
                                    else if(hotdogtype[i].contains("小"))
                                    {
                                        hotprice +=40;
                                    }
                                    getFoodprice += hotprice*hotsum;
                                    textchange();
                                }
                            }
                            getTotalfoods+=" ";
                        }
                    });
                    bdr.show();
                }
            });
            bdr2.show();
            hotprice = 0;
            hotsum = 0;
        }
        else if(foodcc.equals("雪碧"))
        {
            android.app.AlertDialog.Builder bdr2 = new android.app.AlertDialog.Builder(MainActivity.this);
            bdr2.setTitle("雪碧");
            bdr2.setIcon(R.drawable.sprite);
            bdr2.setMultiChoiceItems(drinktype, dri, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    dri[which] = isChecked;
                }
            });
            bdr2.setNegativeButton("選擇數量", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    android.app.AlertDialog.Builder bdr = new android.app.AlertDialog.Builder(MainActivity.this);
                    bdr.setTitle("數量");
                    bdr.setSingleChoiceItems(quantity, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods += " "+quantity[which]+"杯";
                            drisum = Integer.parseInt(quantity[which]);
                        }
                    });
                    bdr.setNegativeButton("確認訂單", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods+=" "+"雪碧"+" ";
                            for(int i = 0 ; i< dri.length ; i++)
                            {
                                if(dri[i]==true)
                                {
                                    if(drinktype[i].contains("冰"))
                                    {
                                        getTotalfoods+="冰塊:"+drinktype[i];
                                    }
                                    else
                                        getTotalfoods+="Size:"+drinktype[i]+" ";
                                    if(drinktype[i].contains("大"))
                                    {
                                        driprice+=60;
                                    }
                                    else if(drinktype[i].contains("中"))
                                    {
                                        driprice+=40;
                                    }
                                    else if(drinktype[i].contains("小"))
                                    {
                                        driprice+=20;
                                    }
                                    getFoodprice += driprice*drisum;
                                    textchange();
                                }
                            }
                            getTotalfoods+=" ";
                        }
                    });
                    bdr.show();
                }
            });
            bdr2.show();
            driprice = 0;
            drisum = 0;
        }
        else if(foodcc.equals("可樂"))
        {
            android.app.AlertDialog.Builder bdr2 = new android.app.AlertDialog.Builder(MainActivity.this);
            bdr2.setTitle("可樂");
            bdr2.setIcon(R.drawable.coca);
            bdr2.setMultiChoiceItems(drinktype, dri, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    dri[which] = isChecked;
                }
            });
            bdr2.setNegativeButton("選擇數量", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    android.app.AlertDialog.Builder bdr = new android.app.AlertDialog.Builder(MainActivity.this);
                    bdr.setTitle("數量");
                    bdr.setSingleChoiceItems(quantity, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods += " "+quantity[which]+"杯";
                            drisum = Integer.parseInt(quantity[which]);
                        }
                    });
                    bdr.setNegativeButton("確認訂單", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods+=" "+"可樂"+" ";
                            for(int i = 0 ; i< dri.length ; i++)
                            {
                                if(dri[i]==true)
                                {
                                    if(drinktype[i].contains("冰"))
                                    {
                                        getTotalfoods+="冰塊:"+drinktype[i];
                                    }
                                    else
                                        getTotalfoods+="Size:"+drinktype[i]+" ";
                                    if(drinktype[i].contains("大"))
                                    {
                                        driprice+=60;
                                    }
                                    else if(drinktype[i].contains("中"))
                                    {
                                        driprice+=40;
                                    }
                                    else if(drinktype[i].contains("小"))
                                    {
                                        driprice+=20;
                                    }
                                    getFoodprice += driprice*drisum;
                                    textchange();
                                }
                            }
                            getTotalfoods+=" ";
                        }
                    });
                    bdr.show();
                }
            });
            bdr2.show();
            drisum = 0;
            driprice = 0;
        }
        else if(foodcc.equals("咖啡"))
        {
            android.app.AlertDialog.Builder bdr2 = new android.app.AlertDialog.Builder(MainActivity.this);
            bdr2.setTitle("咖啡");
            bdr2.setIcon(R.drawable.coffee);
            bdr2.setMultiChoiceItems(coffeetype, cof, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    cof[which] = isChecked;
                }
            });
            bdr2.setNegativeButton("選擇數量", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    android.app.AlertDialog.Builder bdr = new android.app.AlertDialog.Builder(MainActivity.this);
                    bdr.setTitle("數量");
                    bdr.setSingleChoiceItems(quantity, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getTotalfoods += " "+quantity[which]+"杯";
                            cofsum = Integer.parseInt(quantity[which]);
                        }
                    });
                    bdr.setNegativeButton("確認訂單", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for(int i = 0 ; i< cof.length ; i++)
                            {
                                if(cof[i]==true)
                                {
                                    if(coffeetype[i].contains("冰"))
                                    {
                                        getTotalfoods+=" "+"冰咖啡"+" ";
                                    }
                                    else if(coffeetype[i].contains("熱"))
                                    {
                                        getTotalfoods+=" "+"熱咖啡"+" ";
                                    }
                                    else
                                        getTotalfoods+="Size:"+coffeetype[i];
                                    if(coffeetype[i].contains("大"))
                                    {
                                        cofprice+=80;
                                    }
                                    else if(coffeetype[i].contains("中"))
                                    {
                                        cofprice+=60;
                                    }
                                    else if(coffeetype[i].contains("小"))
                                    {
                                        cofprice+=40;
                                    }
                                    getFoodprice+=cofprice*cofsum;
                                    textchange();
                                }
                            }
                            getTotalfoods+=" ";
                        }
                    });
                    bdr.show();
                }
            });
            bdr2.show();
            cofprice = 0;
            cofsum = 0;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        String[] action;
        String[] action2 = new String[0];
        String[] action3 = new String[0];
        if (parent.getId() == R.id.splocation) {
            if (splocation.getSelectedItemPosition() == 0) {
                action = getResources().getStringArray(R.array.台北);
            } else if (splocation.getSelectedItemPosition() == 1) {
                action = getResources().getStringArray(R.array.台中);
            } else {
                action = getResources().getStringArray(R.array.台南);
            }
            for (int j = 0; j < action.length; j++) {
                list.add(action[j]);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_gallery_item, list);
            adapter.setDropDownViewResource(android.R.layout.simple_gallery_item);
            sptheater.setAdapter(adapter);
            if(theaterw.equals("信義威秀影城"))
            {
                sptheater.setSelection(0);
            }
            else if(theaterw.equals("東南亞秀泰影城"))
            {
                sptheater.setSelection(1);
            }
            else if(theaterw.equals("台北新光影城"))
            {
                sptheater.setSelection(2);
            }
            else if(theaterw.equals("臺中大遠百威秀影城"))
            {
                sptheater.setSelection(0);
            }
            else if(theaterw.equals("台中站前秀泰影城"))
            {
                sptheater.setSelection(1);
            }
            else if(theaterw.equals("台中新光影城"))
            {
                sptheater.setSelection(2);
            }
            else if(theaterw.equals("台南大遠百威秀影城"))
            {
                sptheater.setSelection(0);
            }
            else if(theaterw.equals("台南國賓影城"))
            {
                sptheater.setSelection(1);
            }
            else if(theaterw.equals("台南新光影城"))
            {
                sptheater.setSelection(2);
            }
        }
        else if (parent.getId() == R.id.spmovie) {
            if(spmovie.getSelectedItemPosition() == 0)
            {
                action2 = getResources().getStringArray(R.array.one);
            }
            else if (spmovie.getSelectedItemPosition() == 1)
            {
                action2 = getResources().getStringArray(R.array.玩命關頭9);
            }
            else if (spmovie.getSelectedItemPosition() == 2)
            {
                action2 = getResources().getStringArray(R.array.當男人戀愛時);
            }
            else if (spmovie.getSelectedItemPosition() == 3)
                {
                action2 = getResources().getStringArray(R.array.捍衛戰士獨行俠);
            }
            else if (spmovie.getSelectedItemPosition() == 4)
            {
                action2 = getResources().getStringArray(R.array.黑寡婦);
            }

            for (int j = 0; j < action2.length; j++) {
                list2.add(action2[j]);
            }

            ArrayAdapter<String> adapter2=new ArrayAdapter(this,android.R.layout.simple_gallery_item,list2);
            adapter2.setDropDownViewResource(android.R.layout.simple_gallery_item);
            spwhen.setAdapter(adapter2);
            if(lvindex == 0)
            {
                spwhen.setSelection(0);
            }
            else if(lvindex == 1)
            {
                spwhen.setSelection(1);
            }
            else if(lvindex == 2)
            {
                spwhen.setSelection(2);
            }
            else if(lvindex == 3)
            {
                spwhen.setSelection(3);
            }
            else if(lvindex == 4)
            {
                spwhen.setSelection(4);
            }

        }
        else if (parent.getId() == R.id.spwhen)
        {
            if (spwhen.getSelectedItemPosition() == 0)
            {
                action3 = getResources().getStringArray(R.array.ticket);
            }
            else
            {
                action3 = getResources().getStringArray(R.array.noearly);//若不是早場不能買早場票
            }
            for (int j = 0; j < action3.length; j++) {
                list3.add(action3[j]);
            }

            ArrayAdapter<String> adapter3=new ArrayAdapter(this,android.R.layout.simple_gallery_item,list3);
            adapter3.setDropDownViewResource(android.R.layout.simple_gallery_item);
            spearly.setAdapter(adapter3);
        }

        else if (parent.getId() == R.id.spchild)
        {
            if(spchild.getSelectedItem().toString().equals("0") )
            {
                childticket = "";
            }
            else
                childticket = " "+"優待票"+spchild.getSelectedItem().toString()+"張";
            childprice = 200*Integer.parseInt(spchild.getSelectedItem().toString());
        }
        else if (parent.getId() == R.id.spadult)
        {
            if(spadult.getSelectedItem().toString().equals("0") )
            {
                adultticket = "";
            }
            else
                adultticket = " "+"全票"+spadult.getSelectedItem().toString()+"張";
            adultprice = 260*Integer.parseInt(spadult.getSelectedItem().toString());
        }
        else if (parent.getId() == R.id.spearly)
        {
            if(spearly.getSelectedItem().toString().equals("0") )
            {
                earlyticket = "";
            }
            else
                earlyticket = " "+"早場票"+spearly.getSelectedItem().toString()+"張";
            earlyprice = 220*Integer.parseInt(spearly.getSelectedItem().toString());
        }
        ticket = childticket+adultticket+earlyticket;
        getTicketprice = adultprice+childprice+earlyprice;
        movietime = spmovie.getSelectedItem().toString()+spwhen.getSelectedItem().toString();
        textchange();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}