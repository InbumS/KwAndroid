package com.example.finals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.finals.R;

import java.util.ArrayList;
import java.util.List;

//Adaptor를 변형시킨 커스텀 어뎁터
public class CustomAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List list;

    //리스트뷰 아이템 클릭시 변형
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
    }

    //viewHolder 클래스선언
    class ViewHolder {
        public TextView tv_name;
        public TextView tv_calorie;
        public ImageView iv_thumb;
    }

    //customAdaper 생성자
    public CustomAdapter(Context context, ArrayList list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    // Adapter가 가지고 있는 data 를 어떻게 보여줄 것인가를 정의하는 함수
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        //convertview가 null이면 레이아웃 inflate한다.
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.row_item, parent, false);
        }


        viewHolder = new ViewHolder();
        viewHolder.tv_name = (TextView) convertView.findViewById(R.id.name);
        viewHolder.tv_calorie = (TextView) convertView.findViewById(R.id.calorie);
        viewHolder.iv_thumb = (ImageView) convertView.findViewById(R.id.thumb);

        //커스텀 어댑터뷰의 화면을 꾸미는 작업
        final caffaine drink = (caffaine) list.get(position);
        viewHolder.tv_name.setText(drink.getName());
        viewHolder.tv_calorie.setText(drink.getcalorie());
        //google이미지를 간접적으로 쓰기 위해 Glide선언
        Glide
                .with(context)
                .load(drink.getThumb_url())
                .centerCrop()
                .apply(new RequestOptions().override(250, 350))
                .into(viewHolder.iv_thumb);
        viewHolder.tv_name.setTag(drink.getName());
        viewHolder.tv_calorie.setTag(drink.getcalorie());


        //스크린의 완벽한 뷰를 리턴
        return convertView;
    }
}