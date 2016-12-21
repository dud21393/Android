package com.example.jsy.wordapp.recycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jsy.wordapp.R;


import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<WordItemList> itemList;
    private int itemLayout;

    public RecyclerAdapter(List<WordItemList> items,int itemLayout){
        this.itemList = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WordItemList item = itemList.get(position);
        holder.koreanWord.setText(item.getKorean());
        holder.japaneseWord.setText(item.getJapan());
        holder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView koreanWord;
        public TextView japaneseWord;

        public ViewHolder(View itemView) {
            super(itemView);
            koreanWord = (TextView) itemView.findViewById(R.id.koreanWord);
            japaneseWord = (TextView) itemView.findViewById(R.id.japaneseWord);
        }
    }
}