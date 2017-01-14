package com.example.jsy.wordapp.recycle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jsy.wordapp.R;
import com.example.jsy.wordapp.WordList;


import java.util.List;

/**
 * Created by jsy on 2017-01-14.
 */

public class VocabularyRecyclerAdapter extends RecyclerView.Adapter<VocabularyRecyclerAdapter.ViewHolder> {

    private List<VocabularyItemList> itemList;
    private int itemLayout;

    public VocabularyRecyclerAdapter(List<VocabularyItemList> items, int itemLayout){
        this.itemList = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        VocabularyItemList item = itemList.get(position);
        holder.vocabularyName.setText(item.getVocalbularyName());
        holder.vocabularyName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),WordList.class);
                intent.putExtra("categoryId", position+1);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView vocabularyName;

        public ViewHolder(View itemView) {
            super(itemView);
            vocabularyName = (TextView) itemView.findViewById(R.id.vocabularyName);
        }
    }
}
