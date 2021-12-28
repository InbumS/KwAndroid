package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//secondActivity
public class SecondActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstance){
        setTheme(R.style.Theme_Finals);
        super.onCreate(savedInstance);
        setContentView(R.layout.second);
        Intent intent=new Intent(this,MainActivity.class);

        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        Button btn3=(Button)findViewById(R.id.btn3);
        Button btn4=(Button)findViewById(R.id.btn4);

        //각각의 버튼 클릭시 그에 맞는 Fragment로 트랜잭션 작업
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new Fragment1()).commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new Fragment2()).commit();
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new Fragment3()).commit();

            }
        });

        //mainActivity로 intent를 사용해 이동
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();

            }
        });

    }


}
