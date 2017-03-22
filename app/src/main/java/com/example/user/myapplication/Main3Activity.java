package com.example.user.myapplication;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main3Activity extends AppCompatActivity {
    Switch s1;
    TextView t1;
    Chronometer c1;
    FrameLayout f1;
    GridLayout g1;
    TableLayout table1, table2;
    Button b1, b2;
    DatePicker datepicker;
    TimePicker  timepicker;

    EditText adultCount, youthCount, childCount;

    TextView date, time, adult, youth, child;

    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("레스토랑 예약 시스템");
        init();
    }

    void init(){
        s1 = (Switch)findViewById(R.id.switch1);
        t1 = (TextView)findViewById(R.id.textView9);
        c1 = (Chronometer)findViewById(R.id.chronometer1);
        f1 = (FrameLayout)findViewById(R.id.frame);
        g1 = (GridLayout)findViewById(R.id.grid);
        table1 = (TableLayout)findViewById(R.id.inputTable);
        table2 = (TableLayout)findViewById(R.id.resultTable);
        b1 = (Button)findViewById(R.id.button5);
        b2 = (Button)findViewById(R.id.button6);

        datepicker =(DatePicker)findViewById(R.id.datePicker);
        timepicker = (TimePicker)findViewById(R.id.timePicker);

        adultCount = (EditText)findViewById(R.id.adultCount);
        youthCount = (EditText)findViewById(R.id.youthCount);
        childCount = (EditText)findViewById(R.id.childCount);

        date = (TextView)findViewById(R.id.date);
        time = (TextView)findViewById(R.id.time);
        adult = (TextView)findViewById(R.id.adult);
        youth = (TextView)findViewById(R.id.youth);
        child = (TextView)findViewById(R.id.child);


        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(s1.isChecked()){
                    t1.setVisibility(View.VISIBLE);

                    c1.start();
                    c1.setVisibility(View.VISIBLE);

                    f1.setVisibility(View.VISIBLE);
                    g1.setVisibility(View.VISIBLE);
                    page = 0;
                    b1.setEnabled(false);


                }else{
                    t1.setVisibility(View.INVISIBLE);

                    c1.setVisibility(View.INVISIBLE);
                    c1.setBase(SystemClock.elapsedRealtime());

                    f1.setVisibility(View.INVISIBLE);
                    g1.setVisibility(View.INVISIBLE);
                    page = 0;
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page>0){
                    page--;
                    b1.setEnabled(false);
                }if(page == 0){
                    datepicker.setVisibility(View.VISIBLE);
                    timepicker.setVisibility(View.INVISIBLE);
                }else if(page == 1){
                    timepicker.setVisibility(View.VISIBLE);
                    table1.setVisibility(View.INVISIBLE);
                }else if(page ==2){
                    c1.start();
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    table1.setVisibility(View.VISIBLE);
                    table2.setVisibility(View.INVISIBLE);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page<3){
                    page++;
                    b2.setEnabled(true);
                }
                if(page == 1){
                    b1.setEnabled(true);
                    datepicker.setVisibility(View.INVISIBLE);
                    timepicker.setVisibility(View.VISIBLE);
                }else if(page == 2){
                    timepicker.setVisibility(View.INVISIBLE);
                    table1.setVisibility(View.VISIBLE);
                }else if(page ==3){
                    c1.stop();
                    b1.setEnabled(true);
                    b2.setEnabled(false);
                    table1.setVisibility(View.INVISIBLE);
                    table2.setVisibility(View.VISIBLE);

                    date.setText(datepicker.getYear()+"년 "+datepicker.getMonth()+"월 "+datepicker.getDayOfMonth()+"일");
                    time.setText(timepicker.getHour()+"시 "+timepicker.getMinute()+"분");
                    adult.setText(adultCount.getText()+"명");
                    youth.setText(youthCount.getText()+"명");
                    child.setText(childCount.getText()+"명");

                }
            }
        });





    }
}
