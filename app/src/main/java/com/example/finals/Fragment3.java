package com.example.finals;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

//세번재 Fragment
public class Fragment3 extends Fragment implements View.OnClickListener {
    ArrayList<Item> item_list;
    Button btnADD;
    EditText f3edt1;
    EditText f3edt2;
    ListView listView;
    
    //MinicustomAdapter커스텀 객체 사용
    private static MiniCustomAdapter ca;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // data를 가져와서 어답터와 연결해 준다. 서버에서 가져온다.
        View rootView = inflater.inflate(R.layout.fragment3, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview1);
        btnADD = (Button) rootView.findViewById(R.id.f3btn);
        f3edt1 = (EditText) rootView.findViewById(R.id.f3edt1);
        f3edt2 = (EditText) rootView.findViewById(R.id.f3edt2);
        item_list = new ArrayList<>();
        ca = new MiniCustomAdapter(getActivity(), R.layout.short_item, item_list);
        btnADD.setOnClickListener(this);
        listView.setAdapter(ca);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                String selectedItem = (String)view.findViewById(R.id.f3name).getTag().toString();
                String selectedCalorie=(String)view.findViewById(R.id.f3calorie).getTag().toString();
                int calorietoint=Integer.parseInt(selectedCalorie);
                Intent intent2 = new Intent(getActivity(),ThirdActivity.class);
                intent2.putExtra("extra",calorietoint);
                startActivity(intent2);

            }
        });
        return rootView;




    }

    //등록 클릭시 리스트뷰에 입력받은 데이터 저장 및 MiniCustomAdaptor에 Update
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f3btn:
                Item item = new Item(f3edt1.getText().toString(), f3edt2.getText().toString());
                item_list.add(item);
                ca.notifyDataSetChanged();
                break;
        }
    }

}


