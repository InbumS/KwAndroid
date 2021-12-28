package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//세번째 Activity
public class ThirdActivity extends AppCompatActivity {
    double total=0;
    TextView ttv;
    TextView ttv2;
    TextView ttv3;
    TextView ttv7;
    Button tbtn;
    Button tbtn3;
    Button tbtn2;
    public void onCreate(Bundle SavedInstanceState) {
        setTheme(R.style.Theme_Finals);
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.third);
        Intent intentreceive=getIntent();
        tbtn=(Button)findViewById(R.id.tbtn);
        tbtn2=(Button)findViewById(R.id.tbtn2);
        tbtn3=(Button)findViewById(R.id.tbtn3);
        ttv7=(TextView)findViewById(R.id.ttv7);
        ttv=(TextView)findViewById(R.id.ttv);
        ttv2=(TextView)findViewById(R.id.ttv2);
        ttv3=(TextView)findViewById(R.id.ttv3);



        Double caloriename=intentreceive.getDoubleExtra("calorie",0);
        int coffiecalorie=intentreceive.getIntExtra("coffee",0);
        int drinkcalorie=intentreceive.getIntExtra("drink",0);
        int extracalorie=intentreceive.getIntExtra("extra",0);


        var.total=var.total+coffiecalorie;
        var.total=var.total+drinkcalorie;
        var.total=var.total+extracalorie;

        //caloriename이 0이 아니면 static으로 선언된 caloriename에 caloriename선언언
       if (caloriename!=0)
            var.caloriename=caloriename;

       //비율 구하는 식
        double ratio=(var.total/var.caloriename)*100;

        var.ratio=ratio;
        ttv.setText(var.caloriename+"mg");
        ttv2.setText(var.total+"mg");
        ttv3.setText(var.ratio+"%");

        //NaN을 액티비티에 안뜨게 만든다
        if(Double.isInfinite(ratio) || Double.isNaN(ratio))
        {
            ttv3.setText("0%");

        };

        //상태 알림창
        if (var.ratio<25) {
            ttv7.setText("Little Caffaine");
        } else if (var.ratio<50) {
            ttv7.setText("카페인의 여유를 즐겨보세요");
        } else if (var.ratio<75)
            ttv7.setText("지금 카페인이 몸에 쌓이고 있습니다");
        else if (var.ratio<100)
            ttv7.setText("카페인을 조심하세요");
        else
            ttv7.setText("카페인을 더 섭취하면 위험");


        //초기화함수
        tbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.ratio=0;
                var.total=0;
                var.caloriename=0;
                ttv.setText("0mg");
                ttv2.setText("0mg");
                ttv3.setText("0%");
                ttv7.setText("Small Caffaine");
            }
        });


        tbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        registerForContextMenu(tbtn);


    }

    //context menu 생성
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu,v,menuInfo);
    }

    //context item 선택함수
    public boolean onContextItemSelected(@NonNull MenuItem item){

        //개발자 정보
        switch (item.getItemId()){

            case R.id.maker:
                Toast.makeText(this,"송인범",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.hometown:
                Toast.makeText(this,"대전광역시",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.belong:
                Toast.makeText(this,"광운대학교",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favorite:
                Toast.makeText(this,"몬스터 망고로코",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.tel:
                Toast.makeText(this,"010-5203-0474",Toast.LENGTH_SHORT).show();
                return true;


        }
        return super.onContextItemSelected(item);
    }
}



