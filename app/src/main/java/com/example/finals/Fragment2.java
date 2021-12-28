package com.example.finals;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

//두번째 Fragment
public class Fragment2 extends Fragment {
    ArrayList<caffaine> drink;
    ListView customListView;
    private static CustomAdapter customAdapter2;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // fragment에 layout inflate
        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        //data를 가져와서 어답터와 연결해 준다. 서버에서 가져온다.
        drink = new ArrayList<>();
        drink.add(new caffaine("스누피 커피우유","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJdwUZFP764T0QOAbbYzp-otNjUUNs4HwiYA&usqp=CAU","237"));
        drink.add(new caffaine("핫식스", "https://static.1hourmart.kr/data/product/d9133c27eaa608c7d37cf7e7d9fce6fd/thumbd69cba36b124d4f092d6747fd339692f.jpg","60"));
        drink.add(new caffaine("몬스터 에너지","https://image.ajunews.com/content/image/2020/07/01/20200701125208270128.png","100" ));
        drink.add(new caffaine("커피맛 우유","https://contents.lotteon.com/itemimage/_v104713/LF/13/70/60/4_/0/LF1370604_0_1.jpg/dims/resizef/720X720","85" ));
        drink.add(new caffaine("레드불 에너지", "https://w.namu.la/s/d8b3ba6621254af359b9765222f5b83feabd7f88d18de38082d79d1b5b25ed8735323c0067b72db693cf8f2bcc64a3acda5736ca768e642b546655481f2f79a49989949132fea3720fb7aa31249f9830","63" ));
        drink.add(new caffaine("박카스","https://image.news1.kr/system/photos/2018/9/5/3286731/medium.jpg","30"));
        drink.add(new caffaine("라이톨","https://post-phinf.pstatic.net/MjAyMDEyMTRfMTQy/MDAxNjA3ODk2MTYwMjM4.CCKiwliOFcqj94d6ryRjdcJLwGkU6KodFAI_bD_Asskg.CTxfcE0Sw6jd9TKPzAUiugNgx4FK9VBYP_sqT3JaNDYg.PNG/Is2LYiKf39WrdMYx5q5wd5SDkRDI.jpg?type=w400","150"));
        drink.add(new caffaine("핫식스 더킹","https://contents.lotteon.com/itemimage/_v144014/LO/10/29/79/45/86/_1/02/97/94/58/7/LO1029794586_1029794587_1.jpg/dims/resizef/720X720","100"));
        drink.add(new caffaine("데자와","https://t1.daumcdn.net/cfile/tistory/99BEF84D5C34554704","55"));
        drink.add(new caffaine("레쓰비", "https://www.costco.co.kr/medias/sys_master/h04/h5c/8810677764126.jpg","74"));

        customListView = (ListView) rootView.findViewById(R.id.listView_custom);
        customAdapter2 = new CustomAdapter(getContext(),drink);
        customListView.setAdapter(customAdapter2);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                String selectedItem = (String) view.findViewById(R.id.name).getTag().toString();
                String selectedCalorie=(String)view.findViewById(R.id.calorie).getTag().toString();
                int calorietoint=Integer.parseInt(selectedCalorie);
                Intent intent2 = new Intent(getActivity(),ThirdActivity.class);
                intent2.putExtra("drink",calorietoint);
                startActivity(intent2);
            }
        });

        return rootView;
    }
}


