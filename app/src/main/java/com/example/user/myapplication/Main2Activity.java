package com.example.user.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2, e3;
    TextView t1, t2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("알림","두번째 액티비티 생성");
        setTitle("학점 계산");
        init();


    }

    void init(){
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);

        e1 = (EditText)findViewById(R.id.editText4);
        e2 = (EditText)findViewById(R.id.editText5);
        e3 = (EditText)findViewById(R.id.editText6);

        t1 = (TextView)findViewById(R.id.textView2);
        t2 = (TextView)findViewById(R.id.textView4);

        iv = (ImageView)findViewById(R.id.imageView);
        Log.i("알림", "findViewById");
        //iv.setVisibility(View.INVISIBLE);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String han = e1.getText().toString();
                int hanScore = 0;
                if(!han.equals("")){
                    Log.i("알림","han if 지남");
                    hanScore = Integer.parseInt(han);
                }

                String mat = e2.getText().toString();
                int matScore = 0;
                if(!mat.equals("")){
                    Log.i("알림","mat if 지남");
                    matScore = Integer.parseInt(mat);
                }
                String eng = e3.getText().toString();
                int engScore = 0;
                if(!eng.equals("")){
                    Log.i("알림","eng if 통과");
                    engScore = Integer.parseInt(eng);
                }

                int total = hanScore + matScore + engScore;
                int avg = total/3;

                if(avg>=90){
                    iv.setImageResource(R.drawable.a);
                   // iv.setVisibility(View.VISIBLE);
                }else if(avg>=80){
                    iv.setImageResource(R.drawable.b);

                }else if(avg>=70) {
                    iv.setImageResource(R.drawable.c);
                   // iv.setVisibility(View.INVISIBLE);
                }else if(avg>=60){
                    iv.setImageResource(R.drawable.d);
                   // iv.setVisibility(View.INVISIBLE);
                }else{
                    iv.setImageResource(R.drawable.f);
                   // iv.setVisibility(View.INVISIBLE);
                }

                t1.setText(""+total);
                t2.setText(""+avg);

            }
        });

        b2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                e1.setText("");
                e2.setText("");
                e3.setText("");

                e1.setHint("점수입력");
                e2.setHint("점수입력");
                e3.setHint("점수입력");

                t1.setText(""+0);
                t2.setText(""+0);

                iv.setImageResource(0);
                Toast.makeText(getApplicationContext(),"초기화 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
