package com.example.jsy.wordapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jsy on 2016-12-17.
 */

public class WordAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public WordAdapter(){  }

    @Override
    public int getCount(){
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view,parent,false);
        }

        TextView tv1 = (TextView) convertView.findViewById(R.id.japaneseWord);
        TextView tv2 = (TextView) convertView.findViewById(R.id.koreanWord);

        ListViewItem listViewItem = listViewItemList.get(position);

        tv1.setText(listViewItem.getTv1());
        tv2.setText(listViewItem.getTv2());

        return convertView;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(String tv1, String tv2) {
        ListViewItem item = new ListViewItem();

        item.setTv1(tv1);
        item.setTv2(tv2);

        listViewItemList.add(item);
    }


}
