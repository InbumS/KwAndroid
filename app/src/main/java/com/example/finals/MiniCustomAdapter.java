package com.example.finals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//카페인 식품 이름과 칼로리를 입력받은 값을 리스트뷰로 바꿀 CustomAdapterView
public class MiniCustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    int layout;
    ArrayList<Item> alist;

    //MiniCutomAdapter 생성자
    public MiniCustomAdapter(Context context, int layout, ArrayList<Item> alist) {
        this.context = context;
        this.layout = layout;
        this.alist = alist;
        inflater = LayoutInflater.from(context);
    }


    class ViewHolder{

        public TextView f3name;
        public TextView f3calorie;
    }


    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public Object getItem(int position) {
        return alist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    //View를 확인해 없으면 convertView생성, 존재할시 기존 View 재활용
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        final ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, parent, false);
        }
        viewHolder = new ViewHolder();
        viewHolder.f3name = (TextView) convertView.findViewById(R.id.f3name);
        viewHolder.f3calorie = (TextView) convertView.findViewById(R.id.f3calorie);
        LinearLayout item_layout = (LinearLayout) convertView.findViewById(R.id.item_layout);
        viewHolder.f3name.setText(alist.get(position).getName());
        viewHolder.f3calorie.setText(alist.get(position).getCalorie());
        viewHolder.f3name.setTag(alist.get(position).getName());
        viewHolder.f3calorie.setTag(alist.get(position).getCalorie());






        return convertView;
    }
}

