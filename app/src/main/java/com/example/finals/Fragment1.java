package com.example.finals;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

//첫번째 Fragment
public class Fragment1 extends Fragment {

    //CustomAdapter 객체 사용 및 caffaine클래스를 활용한 coffee객체 생성
    ArrayList<caffaine> coffee;
    ListView customListView;
    private static CustomAdapter customAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // fragment에 layout inflate
        View rootView = inflater.inflate(R.layout.fragment1, container, false);


        //data를 가져와서 어답터와 연결해 준다. 서버에서 가져온다.
        coffee = new ArrayList<>();
        coffee.add(new caffaine("스타벅스 카페 아메리카노", "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[94]_20210430103337157.jpg","150"));
        coffee.add(new caffaine("스타벅스 자바칩 프라푸치노", "https://image.istarbucks.co.kr/skuImg/[168016]_20210415154151606.jpg", "100"));
        coffee.add(new caffaine("스타벅스 돌체 콜드브루", "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002081]_20210415133656839.jpg", "150"));
        coffee.add(new caffaine("스타벅스 에스프레소", "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[20]_20210415144112850.jpg", "75"));
        coffee.add(new caffaine("스타벅스 아이스 카페 라떼", "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110569]_20210415143036138.jpg", "75"));
        coffee.add(new caffaine("할리스 아메리카노","https://admin.hollys.co.kr/upload/menu/etc/menuEtc_201905220142317090.png","114"));
        coffee.add(new caffaine("할리스 카페라떼","https://admin.hollys.co.kr/upload/menu/etc/menuEtc_201905220139212410.png","127"));
        coffee.add(new caffaine("할리스 카페모카","https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202009101012563460.png","132"));
        coffee.add(new caffaine("할리스 카라멜 마키아또","https://admin.hollys.co.kr/upload/menu/etc/menuEtc_201905220126041160.png","127"));
        coffee.add(new caffaine("할리스 바닐라 딜라이트","https://admin.hollys.co.kr/upload/menu/etc/menuEtc_201905220115552550.png","80"));
        coffee.add(new caffaine("파스쿠찌 원조커피","https://www.caffe-pascucci.co.kr/upload/product/%EC%97%90%EC%8A%A4%ED%94%84%EB%A0%88%EC%86%8C_16951.jpg","138"));
        coffee.add(new caffaine("파스쿠찌 아메리카노","https://www.caffe-pascucci.co.kr/upload/product/%EC%95%84%EB%A9%94%EB%A6%AC%EC%B9%B4%EB%85%B8_155657.jpg","242"));
        coffee.add(new caffaine("파스쿠찌 카페라떼","https://www.caffe-pascucci.co.kr/upload/product/%EC%B9%B4%ED%8E%98%EB%9D%BC%EB%96%BC_155720.jpg","218"));
        coffee.add(new caffaine("파스쿠찌 콜드브루아메리카노","https://www.caffe-pascucci.co.kr/upload/product/%EC%BD%9C%EB%93%9C%EB%B8%8C%EB%A3%A8%EC%95%84%EB%A9%94%EB%A6%AC%EC%B9%B4%EB%85%B8_155132.jpg","178"));
        coffee.add(new caffaine("파스쿠찌 바닐라 라떼 마끼아또","https://www.caffe-pascucci.co.kr/upload/product/%EB%B0%94%EB%8B%90%EB%9D%BC%EB%9D%BC%EB%96%BC%EB%A7%88%EB%81%BC%EC%95%84%EB%98%90_16329.jpg","219"));
        coffee.add(new caffaine("투썸플레이스 아메리카노","https://mcdn.twosome.co.kr/menu_image/P_MA_Z_TSPLC_MENU_REG/1000/1000/PITEM/10100001_01_01_20210611.jpg?width=600&height=600&q=100","177"));
        coffee.add(new caffaine("투썸플레이스 카페라떼","https://mcdn.twosome.co.kr/menu_image/P_MA_Z_TSPLC_MENU_REG/1000/1000/PITEM/10100002_01_01_20210611.jpg?width=600&height=600&q=100","177"));
        coffee.add(new caffaine("투썸플레이스 콜드브루","https://mcdn.twosome.co.kr/menu_image/P_MA_Z_TSPLC_MENU_REG/1000/1000/PITEM/123.png?width=600&height=600&q=100","196"));
        coffee.add(new caffaine("투썸플레이스 카라멜치즈라떼","https://mcdn.twosome.co.kr/menu_image/P_MA_Z_TSPLC_MENU_REG/1000/1000/PITEM/10191223_01_01_20211012.jpg?width=600&height=600&q=100","152"));
        coffee.add(new caffaine("투썸플레이스 카푸치노","https://mcdn.twosome.co.kr/menu_image/P_MA_Z_TSPLC_MENU_REG/1000/1000/PITEM/174.png?width=600&height=600&q=100","177"));
        coffee.add(new caffaine("이디야 민트모카","https://mblogthumb-phinf.pstatic.net/MjAyMDA2MTBfMjUy/MDAxNTkxNzc0MDU3Mzk3.WfsVasiJ1Byplmm_YArBXengNQfypdPnuUrj4fO83d4g.LiiyCEwd4gVboEnBf8rdcOCwegVygmN09HuT6sEXPNYg.PNG.tintemn/%EC%9D%B4%EB%94%94%EC%95%BC_%EC%95%84%EC%9D%B4%EC%8A%A4_%EB%AF%BC%ED%8A%B8%EB%AA%A8%EC%B9%B4.PNG?type=w800","124"));
        coffee.add(new caffaine("이디야 화이트 초콜릿 모카","https://mblogthumb-phinf.pstatic.net/MjAxODA5MjFfMTU3/MDAxNTM3NTAwNDQ4ODg2.hKbyADOx1_3ka-W9T4TnFVEnSX9ao1uSaZlyUpM3T00g.Ahe-4urSEF17Smdp7Xt8ow1HHtYZ99CUg0V3Z9bhMO4g.JPEG.hk920820/output_2541370612.jpg?type=w800","103"));
        coffee.add(new caffaine("이디야 카페 모카","https://img.giftting.co.kr/goods/G00000140550/G00000140550_550.jpg","197"));
        coffee.add(new caffaine("이디야 카페라떼","https://www.ediya.com/files/menu/IMG_1523925480622.png","103"));
        coffee.add(new caffaine("이디야 카페 아메리카노","https://cdn.ppomppu.co.kr/zboard/data3/2020/0520/m_20200520075441_iunxulaz.jpg","103"));

        customListView = (ListView) rootView.findViewById(R.id.listView_custom);
        customAdapter = new CustomAdapter(getContext(),coffee);
        customListView.setAdapter(customAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰

                    String selectedCalorie=(String)view.findViewById(R.id.calorie).getTag().toString();
                    int calorietoint=Integer.parseInt(selectedCalorie);
                    Intent intent2 = new Intent(getActivity(),ThirdActivity.class);
                    intent2.putExtra("coffee",calorietoint);
                    startActivity(intent2);



            }
        });

        return rootView;
    }
}



