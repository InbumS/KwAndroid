package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


//첫번째 화면 클릭시 엑티비티
public class FirstActivity extends AppCompatActivity {
    NavigationBarView bottomNavigationView;
    Menu menu;
    RadioButton rbtn1;
    RadioButton rbtn2;
    RadioGroup rg1;
    EditText edit1;
    EditText edit2;
    double intake = 0;
    int weight=0;

    //시작할때 실행
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Finals);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        rbtn1= (RadioButton) findViewById(R.id.rbtn1);
        rbtn2= (RadioButton) findViewById(R.id.rbtn2);
        rg1= (RadioGroup) findViewById(R.id.Rg1);
        edit1= (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        Intent intent1 = new Intent(this,ThirdActivity.class);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            String weight2;
            //radioGroup checkbox선택에 따른 섭취량 계산
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if ( edit2.getText().toString().length() == 0 ) {
                    weight=0;


                } else {

                    weight2 = edit2.getText().toString();
                    weight = Integer.parseInt(weight2);

                }

                String name;


                if (id == R.id.rbtn1) {
                    intake = 400;
                } else {
                    intake = weight * 2.5;

                }

            }

        });

        //bottomNavigationView을 사용해 옵션메뉴 표현
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        menu=bottomNavigationView.getMenu();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                //버튼 선택에 따른 데이터 전송, 초기화, Main Activity class로 돌아가기
                switch(id){
                    case R.id.enroll:
                        intent1.putExtra("calorie",intake);
                        startActivity(intent1);
                        return true;

                    case R.id.reset:
                        intake = 0;
                        edit1.setText(null);
                        edit2.setText(null);
                        rg1.clearCheck();
                        return true;
                    case R.id.back: {
                        finish();
                        return true;
                    }

                }
                return true;
            }
        });

    }

    //옵션 메뉴 생성
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}
